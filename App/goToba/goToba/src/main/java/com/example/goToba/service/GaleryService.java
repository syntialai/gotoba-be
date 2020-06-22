package com.example.goToba.service;

import com.example.goToba.model.Galery;
import com.example.goToba.payload.request.GaleryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Service
public interface GaleryService {
    Flux<Galery> findAllGalery();

    Mono<Galery> findGaleryBySku(String sku);

    Mono<Galery> addNewFoto(GaleryRequest galeryRequest) throws IOException;

    Mono<Galery> updateBySku(String sku, GaleryRequest request);

    Mono<Galery> suspendBySku(String sku);

    Mono<Galery> activateBySku(String sku);

    String substring(String str);

    Mono<Galery> findFirstByTitle(String title);

}
