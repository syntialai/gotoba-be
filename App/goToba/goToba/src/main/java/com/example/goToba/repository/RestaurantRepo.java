package com.example.goToba.repository;

import com.example.goToba.model.Restaurant;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Repository
public interface RestaurantRepo extends ReactiveMongoRepository<Restaurant,String> {
    Mono<Restaurant> findBySku(String sku);
    Mono<Boolean> deleteBySku(String sku);
    Mono<Boolean> existsBySku(String sku);
}
