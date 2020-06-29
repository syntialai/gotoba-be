package com.example.goToba.repository;

import com.example.goToba.model.OrderDetail;
import com.example.goToba.model.SequenceOrder;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/06/2020.
 */
@Repository
public interface SequenceOrderRepo extends ReactiveMongoRepository<SequenceOrder,String> {
    public Mono<SequenceOrder> findFirstByKey(String key);
    Mono<Boolean> deleteByKey(String key);
}
