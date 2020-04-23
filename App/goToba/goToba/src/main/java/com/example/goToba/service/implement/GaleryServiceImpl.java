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
    public Mono<Galery> addNewFoto(GaleryRequest request) {
        String key = substring(request.getName());
        return Mono.fromCallable(() -> request)
                .flatMap(i -> sequenceGaleryRepo.findFirstByKey(key))
                .doOnNext(i -> sequenceGaleryRepo.deleteByKey(key).subscribe())
                .doOnNext(i -> sequenceGaleryRepo.save(new SequenceGalery(key, "000" + (Integer.parseInt(i.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceGaleryRepo.save(new SequenceGalery(key, "0001")))
                .flatMap(i -> sequenceGaleryRepo.findFirstByKey(key))
                .flatMap(req -> {
                    Galery galery = new Galery(
                            req.getKey() + "_" + "000" + (Integer.parseInt(req.getLast_seq())),
                            request.getName(),
                            request.getTitle(),
                            request.getDescription(),
                            request.getImage(),
                            Boolean.TRUE
                    );
                    return galeryRepo.save(galery);
                });
    }


    @Override
    public Mono<Galery> updateBySku(String sku, GaleryRequest request) {
        return Mono.fromCallable(() -> request)
                .doOnNext(id -> galeryRepo.deleteBySku(sku).subscribe())
                .flatMap(req -> {
                    Galery galery = new Galery(
                            sku,
                            request.getName(),
                            request.getTitle(),
                            request.getDescription(),
                            request.getImage(),
                            Boolean.TRUE
                    );
                    return galeryRepo.save(galery);
                });
    }

    @Override
    public Mono<Galery> suspendBySku(String sku) {
        return Mono.just(galeryRepo.findFirstBySku(sku))
                .flatMap(data -> galeryRepo.findFirstBySku(sku))
                .doOnNext(id -> galeryRepo.deleteBySku(sku).subscribe())
                .doOnNext(request -> {
                    Galery galery = new Galery(
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
                .doOnNext(id -> galeryRepo.deleteBySku(sku).subscribe())
                .doOnNext(request -> {
                    Galery galery = new Galery(
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
    public String substring(String str) {
        return str.substring(0, 4).toUpperCase();
    }
}
