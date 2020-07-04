package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceWisata;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.helper.Strings;
import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.repository.SequenceWisataRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.utils.SkuGenerator;
import com.example.goToba.service.WisataService;
import com.example.goToba.service.elasticService.WisataElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@Service
public class WisataServiceImpl implements WisataService {

    @Autowired
    WisataRepo wisataRepo;

    @Autowired
    SequenceWisataRepo sequenceWisataRepo;

    @Autowired
    ImageService imageService;

    @Autowired
    SkuGenerator skuGenerator;

    @Autowired
    WisataElasticService wisataElasticService;

    @Override
    public Mono<Wisata> addWisata(WisataRequest wisataRequest) {
        String key = skuGenerator.substring(wisataRequest.getCreatedBy()) + StockKeepingUnit.SKU_CONNECTOR + skuGenerator.substring(wisataRequest.getName());
        Mono<Wisata> wisataMono = Mono.fromCallable(() -> wisataRequest)
                .flatMap(dat -> sequenceWisataRepo.findFirstByKey(key))
                .doOnNext(dat -> sequenceWisataRepo.deleteByKey(key).subscribe())
                .doOnNext(dat -> sequenceWisataRepo.save(new SequenceWisata(key, StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(dat.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceWisataRepo.save(new SequenceWisata(key, StockKeepingUnit.SKU_DATA_BEGINNING + "1")))
                .flatMap(data -> {
                    Wisata wisata = new Wisata(
                            StockKeepingUnit.WISATA + StockKeepingUnit.SKU_CONNECTOR + data.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(data.getLast_seq()),
                            wisataRequest.getName(),
                            wisataRequest.getTitle(),
                            wisataRequest.getDescription(),
                            ImagePath.IMAGE_PATH_WISATA + ImagePath.IMAGE_CONNECTOR + data.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(data.getLast_seq()) + ImagePath.IMAGE_EXTENSION,
                            wisataRequest.getLongitude(),
                            wisataRequest.getLatitude(),
                            wisataRequest.getAddress(),
                            wisataRequest.getCreatedBy(),
                            wisataRequest.getPrice(),
                            wisataRequest.getHoursOpen(),
                            Strings.STATUS_ACTIVE
                    );
                    if (wisataRequest.getImage() != "") {
                        try {
                            imageService.addPicture(wisataRequest.getImage(), wisata.getSku(), ImagePath.IMAGE_PATH_WISATA);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    wisataElasticService.save(wisata.toWisata(wisata));
                    return wisataRepo.save(wisata);
                });
        return wisataMono;
    }

    @Override
    public Flux<Wisata> findAll() {
        return wisataRepo.findAll();
    }


    @Override
    public Mono<Wisata> updateWisata(String sku, WisataRequest wisataRequest) {
        return Mono.fromCallable(() -> wisataRequest)
                .flatMap(data -> wisataRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    wisataElasticService.deleteBySku(sku);
                    wisataRepo.deleteBySku(sku).subscribe();
                })
                .flatMap(data -> {
                    Wisata wisata = new Wisata(
                            sku,
                            wisataRequest.getName(),
                            wisataRequest.getTitle(),
                            wisataRequest.getDescription(),
                            data.getImage(),
                            wisataRequest.getLongitude(),
                            wisataRequest.getLatitude(),
                            wisataRequest.getAddress(),
                            wisataRequest.getCreatedBy(),
                            wisataRequest.getPrice(),
                            wisataRequest.getHoursOpen(),
                            data.getStatus()
                    );
                    if (wisataRequest.getImage() != "") {
                        try {
                            imageService.addPicture(wisataRequest.getImage(), wisata.getSku(), ImagePath.IMAGE_PATH_WISATA);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    wisataElasticService.save(wisata.toWisata(wisata));
                    return wisataRepo.save(wisata);
                });
    }

    @Override
    public Mono<Wisata> deleteBySku(String sku) {
        return wisataRepo.findFirstBySku(sku)
                .doOnNext(i -> {
                    wisataElasticService.deleteBySku(sku);
                    wisataRepo.deleteBySku(sku).subscribe();
                })
                .flatMap(data -> {
                    Wisata wisata = new Wisata(
                            sku,
                            data.getName(),
                            data.getTitle(),
                            data.getDescription(),
                            data.getImage(),
                            data.getLongitude(),
                            data.getLatitude(),
                            data.getAddress(),
                            data.getCreatedBy(),
                            data.getPrice(),
                            data.getHoursOpen(),
                            Strings.STATUS_DELETE
                    );
                    wisataElasticService.save(wisata.toWisata(wisata));
                    return wisataRepo.save(wisata);
                });
    }

    @Override
    public Mono<Wisata> findBySku(String sku) {
        return wisataRepo.findFirstBySku(sku);
    }
}
