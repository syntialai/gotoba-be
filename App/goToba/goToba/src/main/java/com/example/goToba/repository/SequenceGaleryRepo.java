package com.example.goToba.repository;

import com.example.goToba.model.SequenceGalery;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 22/04/2020.
 */
public interface SequenceGaleryRepo extends ReactiveMongoRepository<SequenceGalery,String> {
    public Mono<SequenceGalery> findFirstByKey(String key);
    Mono<Boolean> deleteByKey(String key);
}
