package com.example.goToba.service;

import com.example.goToba.model.Wisata;
import com.example.goToba.payload.request.WisataRequest;
import reactor.core.publisher.Flux;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
public interface WisataService {
    public void addWisata(WisataRequest wisataRequest);
    public Flux<Wisata> findAll();
}
