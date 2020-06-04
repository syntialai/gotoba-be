package com.example.goToba.service;

import com.example.goToba.model.TourGuide;
import com.example.goToba.payload.request.TourGuideRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
public interface TourGuideService {
    Flux<TourGuide> findAll();

    Mono<TourGuide> findBySku(String sku);

    Mono<TourGuide> findByName(String name);

    Mono<TourGuide> addTourGuide(TourGuideRequest tourGuideRequest);

    Mono<TourGuide> editTourGuide(TourGuideRequest tourGuideRequest, String sku);

    String substr(String str);
}
