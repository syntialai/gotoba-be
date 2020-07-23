package com.example.goToba.service.implement;

import com.example.goToba.model.Galery;
import com.example.goToba.model.SequenceGalery;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.payload.request.GaleryRequest;
import com.example.goToba.repository.GaleryRepo;
import com.example.goToba.repository.SequenceGaleryRepo;
import com.example.goToba.service.GaleryService;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.utils.RandomGenerator;
import com.example.goToba.service.utils.SkuGenerator;
import com.example.goToba.service.redisService.GaleryServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Service
public class GaleryServiceImpl implements GaleryService {

    @Autowired
    GaleryRepo galeryRepo;

    @Autowired
    SequenceGaleryRepo sequenceGaleryRepo;

    @Autowired
    GaleryServiceRedis galeryServiceRedis;

    @Autowired
    ImageService imageService;

    @Autowired
    SkuGenerator skuGenerator;

    @Autowired
    RandomGenerator randomGenerator;

    private HashOperations hashOperations;

    @Override
    public Flux<Galery> findAllGalery() {
        return galeryRepo.findAll().filter(data -> data.show==true);
    }

    @Override
    public Mono<Galery> findGaleryBySku(String sku) {
        return Mono.fromCallable(() -> sku)
                .flatMap(data -> galeryRepo.findFirstBySku(sku))
                .doOnNext(data -> galeryServiceRedis.add(data))
                .flatMap(req -> {
                    Galery galery = new Galery(
                            req.getId(),
                            req.getSku(),
                            req.getName(),
                            req.getTitle(),
                            req.getDescription(),
                            req.getImage(),
                            req.getShow());
                    galeryServiceRedis.add(galery);
                    return galeryRepo.findFirstBySku(sku);
                });
    }

    @Override
    public Mono<Galery> addNewFoto(GaleryRequest request) throws IOException {
        String key = skuGenerator.substring(request.getName());
        return Mono.fromCallable(() -> request)
                .flatMap(i -> sequenceGaleryRepo.findFirstByKey(key))
                .doOnNext(i -> sequenceGaleryRepo.deleteByKey(key).subscribe())
                .doOnNext(i -> sequenceGaleryRepo.save(new SequenceGalery(key, StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(i.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceGaleryRepo.save(new SequenceGalery(key, StockKeepingUnit.SKU_FIRST_DATA)))
                .flatMap(i -> sequenceGaleryRepo.findFirstByKey(key))
                .flatMap(req -> {
                    Galery galery = new Galery(
                            randomGenerator.randInt(),
                            req.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(req.getLast_seq())),
                            request.getName(),
                            request.getTitle(),
                            request.getDescription(),
                            ImagePath.IMAGE_PATH_GALLERY + ImagePath.IMAGE_CONNECTOR + req.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(req.getLast_seq())) + ImagePath.IMAGE_EXTENSION,
                            Boolean.TRUE
                    );
                    if (galery.getImage() != "") {
                        try {
                            imageService.addPicture(request.getImage(), galery.getSku(), ImagePath.IMAGE_PATH_GALLERY);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    galeryServiceRedis.add(galery);
                    return galeryRepo.save(galery);
                });
    }


    @Override
    public Mono<Galery> updateBySku(String sku, GaleryRequest request) {
        return Mono.fromCallable(() -> request)
                .flatMap(data -> galeryRepo.findFirstBySku(sku))
                .doOnNext(id -> galeryRepo.deleteBySku(sku))
                .flatMap(req -> {
                    Galery galery = new Galery(
                            req.getId(),
                            sku,
                            request.getName(),
                            request.getTitle(),
                            request.getDescription(),
                            req.getImage(),
                            Boolean.TRUE
                    );
                    if (request.getImage() != "") {
                        try {
                            imageService.addPicture(request.getImage(), sku, ImagePath.IMAGE_PATH_GALLERY);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(galeryServiceRedis.hasKey(sku)) {
                        galeryServiceRedis.delete(sku);
                        galeryServiceRedis.add(galery);
                    }
                    return galeryRepo.save(galery);
                });
    }

    @Override
    public Mono<Galery> suspendBySku(String sku) {
        return Mono.just(galeryRepo.findFirstBySku(sku))
                .flatMap(data -> galeryRepo.findFirstBySku(sku))
                .doOnNext(id -> galeryRepo.deleteBySku(sku))
                .doOnNext(request -> {
                    Galery galery = new Galery(
                            request.getId(),
                            sku,
                            request.getName(),
                            request.getTitle(),
                            request.getDescription(),
                            request.getImage(),
                            Boolean.FALSE
                    );
                    galeryRepo.save(galery).subscribe();
                });
    }

    @Override
    public Mono<Galery> activateBySku(String sku) {
        return Mono.just(galeryRepo.findFirstBySku(sku))
                .flatMap(data -> galeryRepo.findFirstBySku(sku))
                .doOnNext(id -> galeryRepo.deleteBySku(sku))
                .doOnNext(request -> {
                    Galery galery = new Galery(
                            request.getId(),
                            sku,
                            request.getName(),
                            request.getTitle(),
                            request.getDescription(),
                            request.getImage(),
                            Boolean.TRUE
                    );
                    galeryRepo.save(galery).subscribe();
                });
    }


    @Override
    public Mono<Galery> findFirstByTitle(String title) {
        return galeryRepo.findFirstByTitle(title);
    }


}
