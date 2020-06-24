package com.example.goToba.repository;

import com.example.goToba.model.SequencePayment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/06/2020.
 */
@Repository
public interface SequencePaymentRepo  extends ReactiveMongoRepository<SequencePayment,String> {
    public Mono<SequencePayment> findFirstByKey(String key);
    Mono<Boolean> deleteByKey(String key);
}
