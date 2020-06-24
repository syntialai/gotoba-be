package com.example.goToba.repository;

import com.example.goToba.model.SequenceRestaurants;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/06/2020.
 */
@Repository
public interface SequenceRestaurantsRepo extends ReactiveMongoRepository<SequenceRestaurants,String> {
    public Mono<SequenceRestaurants> findFirstByKey(String key);
    Mono<Boolean> deleteByKey(String key);
}
