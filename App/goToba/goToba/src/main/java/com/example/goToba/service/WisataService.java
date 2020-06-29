package com.example.goToba.service;

import com.example.goToba.model.Wisata;
import com.example.goToba.payload.request.WisataRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
public interface WisataService {
    public Mono<Wisata> addWisata(WisataRequest wisataRequest);

    public Flux<Wisata> findAll();

    public Mono<Wisata> updateWisata(String sku, WisataRequest wisataRequest);

    public Mono<Wisata> deleteBySku(String sku);

    public Mono<Wisata> findBySku(String sku);
}
