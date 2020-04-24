package com.example.goToba.repository;

import com.example.goToba.model.SequenceWisata;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/04/2020.
 */
@Repository
public interface SequenceWisataRepo extends ReactiveMongoRepository<SequenceWisata,String> {
    public Mono<SequenceWisata> findFirstByKey(String key);
    public Mono<Boolean> deleteByKey(String key);
}
