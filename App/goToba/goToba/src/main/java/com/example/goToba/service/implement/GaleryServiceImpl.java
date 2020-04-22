package com.example.goToba.service.implement;

import com.example.goToba.model.Galery;
import com.example.goToba.model.SequenceGalery;
import com.example.goToba.payload.request.GaleryRequest;
import com.example.goToba.repository.GaleryRepo;
import com.example.goToba.repository.SequenceGaleryRepo;
import com.example.goToba.service.GaleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Service
public class GaleryServiceImpl implements GaleryService {

    @Autowired
    GaleryRepo galeryRepo;
    @Autowired
    SequenceGaleryRepo sequenceGaleryRepo;

    @Override
    public Flux<Galery> findAllGalery() {
        return galeryRepo.findAll();
    }

    @Override
    public Mono<Galery> findGaleryBySku(String sku) {
//        return galeryRepo.findFirstBySku(sku);
        return null;
    }

    @Override
    public Mono<Galery> addNewFoto(GaleryRequest galeryRequest) {
        return Mono.fromCallable(() -> galeryRequest)
                .doOnNext(request -> {
                    Galery gal = new Galery(
                            galeryRequest.getName(),
                            galeryRequest.getTitle(),
                            galeryRequest.getDescription(),
                            galeryRequest.getImage(),
                            Boolean.TRUE
                    );
                })
                .doOnNext(req -> System.out.println("Data res : " + req))
                .flatMap(request -> {
                    Galery gal = new Galery(
                            galeryRequest.getName(),
                            galeryRequest.getTitle(),
                            galeryRequest.getDescription(),
                            galeryRequest.getImage(),
                            Boolean.TRUE
                    );
                    return galeryRepo.save(gal);
                }).doOnSuccess(i -> System.out.println("Add Data Success"));
    }

    @Override
    public void editFotoBySku(GaleryRequest galeryRequest, String sku) {

    }

    @Override
    public Mono<Galery> updateBySku(String sku, GaleryRequest request) {

        return Mono.fromCallable(() -> request)
                .doOnNext(req -> System.out.println(req))
                .map(id -> sku.toString())
                .doOnNext(id -> galeryRepo.deleteBySku(sku).subscribe())
                .flatMap(req -> {
                    Galery galery = new Galery(
                            request.getName(),
                            request.getTitle(),
                            request.getDescription(),
                            request.getImage(),
                            Boolean.TRUE
                    );
                    galery.setSku(sku);
                    return galeryRepo.save(galery);
                });
    }

    @Override
    public Mono<Galery> suspendBySku(String sku) {
        return null;
    }

    @Override
    public Mono<Galery> activateBySku(String sku) {
        return null;
    }

    @Override
    public String skuGenerator(String name) {
        System.out.println("masuk kok");
        String key = substring(name);
        Mono.fromCallable(() -> sequenceGaleryRepo.findFirstByKey(key))
                .flatMap(i -> sequenceGaleryRepo.findFirstByKey(key))
                .doOnNext(i -> sequenceGaleryRepo.deleteByKey(key).subscribe())
                .doOnNext(i -> sequenceGaleryRepo.save(new SequenceGalery(key,"000"+ (Integer.parseInt(i.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceGaleryRepo.save(new SequenceGalery(key, "0001")))
                .subscribe();
        return name.substring(0, 4).toUpperCase();
    }

    @Override
    public String substring(String str) {
        return str.substring(0, 4).toUpperCase();
    }
}
