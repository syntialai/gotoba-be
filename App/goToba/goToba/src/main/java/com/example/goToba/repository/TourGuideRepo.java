package com.example.goToba.repository;

import com.example.goToba.model.TourGuide;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
@Repository
public interface TourGuideRepo extends ReactiveMongoRepository<TourGuide,Integer> {

    Mono<TourGuide> findBySku(String sku);

    Mono<TourGuide> findByName(String name);

}
