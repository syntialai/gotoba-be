package com.example.goToba.repository;

import com.example.goToba.model.Galery;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Repository
public interface GaleryRepo extends ReactiveMongoRepository<Galery, String> {
    Mono<Galery> findFirstBySku(String sku);
    Mono<Boolean> deleteBySku(String sku);
}
