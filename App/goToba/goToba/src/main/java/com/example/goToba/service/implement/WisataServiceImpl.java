package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceWisata;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.redis.template.RedisKeys;
import com.example.goToba.repository.SequenceWisataRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.WisataService;
import com.example.goToba.service.redisService.WisataRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

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
    WisataRedisService wisataRedisService;

    @Autowired
    ImageService imageService;

    @Override
    public Mono<Wisata> addWisata(WisataRequest wisataRequest) {
        String awal = "000";
        String key = substr(wisataRequest.getCreatedBy()) + "_" + substr(wisataRequest.getName());
        Mono<Wisata> wisataMono = Mono.fromCallable(() -> wisataRequest)
                .flatMap(dat -> sequenceWisataRepo.findFirstByKey(key))
                .doOnNext(dat -> sequenceWisataRepo.deleteByKey(key).subscribe())
                .doOnNext(dat -> sequenceWisataRepo.save(new SequenceWisata(key, awal + (Integer.parseInt(dat.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceWisataRepo.save(new SequenceWisata(key, awal + "1")))
                .flatMap(dat -> sequenceWisataRepo.findFirstByKey(key))
                .doOnNext(data -> {
                    File currentDirFile = new File("");
                    String helper = currentDirFile.getAbsolutePath();
                    String currentDir = helper + "/src/main/resources/static/images/Wisata/";
                    String pict = "/get/" + data.getKey() + "_000" + Integer.parseInt(data.getLast_seq()) + ".png";
                    String partSeparator = ",";
                    String encodedImg = "";
                    if (wisataRequest.getImage().contains(partSeparator)) {
                        encodedImg = wisataRequest.getImage().split(partSeparator)[1];
                    }
                    File file = new File(currentDir + "/" + pict);
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        byte[] dataBytes = Base64.getMimeDecoder().decode(encodedImg);
                        fos.write(dataBytes);
                        System.out.println("Image file saved " + wisataRequest.getImage());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                })
                .flatMap(data -> {
                    Wisata wisata = new Wisata(
                            data.getKey() + "_000" + Integer.parseInt(data.getLast_seq()),
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
                            "active"
                    );
                    if (wisataRequest.getImage() != "") {
                        try {
                            imageService.addPicture(wisataRequest.getImage(), wisata.getSkuWisata(), ImagePath.IMAGE_PATH_WISATA);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    wisataRedisService.add(wisata);
                    return wisataRepo.save(wisata);
                });
        return wisataMono;
    }

    @Override
    public Flux<Wisata> findAll() {
        return wisataRepo.findAll();
    }


    @Override
    public String substr(String str) {
        return str.substring(0, 4).toUpperCase();
    }

    @Override
    public Mono<Wisata> updateWisata(String sku, WisataRequest wisataRequest) {
        return Mono.fromCallable(() -> wisataRequest)
                .flatMap(data -> wisataRepo.findFirstBySkuWisata(sku))
                .doOnNext(i -> {
                    wisataRepo.deleteBySkuWisata(sku).subscribe();
                })
                .flatMap(data -> {
                    Wisata wisata = new Wisata(
                            sku,
                            wisataRequest.getName(),
                            wisataRequest.getTitle(),
                            wisataRequest.getDescription(),
                            wisataRequest.getImage(),
                            wisataRequest.getLongitude(),
                            wisataRequest.getLatitude(),
                            wisataRequest.getAddress(),
                            wisataRequest.getCreatedBy(),
                            wisataRequest.getPrice(),
                            wisataRequest.getHoursOpen(),
                            data.getStatus()
                    );
                    if (wisataRedisService.hasKey(sku)) {
                        wisataRedisService.deleteByKey(sku);
                        wisataRedisService.add(wisata);
                    }
                    return wisataRepo.save(wisata);
                });
    }

    @Override
    public Mono<Wisata> deleteBySku(String sku) {
        return wisataRepo.findFirstBySkuWisata(sku)
                .doOnNext(i -> {
                    wisataRepo.deleteBySkuWisata(sku).subscribe();
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
                            "blocked"
                    );
                    return wisataRepo.save(wisata);
                });
    }

    @Override
    public Mono<Wisata> findBySku(String sku) {
        return wisataRepo.findFirstBySkuWisata(sku);
    }
}
