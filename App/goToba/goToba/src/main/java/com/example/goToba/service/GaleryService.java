package com.example.goToba.service;

import com.example.goToba.model.Galery;
import com.example.goToba.payload.request.GaleryRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Service
public interface GaleryService {
    public Flux<Galery> findAllGalery();

    public Mono<Galery> findGaleryBySku(String sku);

    public Mono<Galery> addNewFoto(GaleryRequest galeryRequest);

    public void editFotoBySku(GaleryRequest galeryRequest, String sku);

    public Mono<Galery> updateBySku(String sku, GaleryRequest request);
}
