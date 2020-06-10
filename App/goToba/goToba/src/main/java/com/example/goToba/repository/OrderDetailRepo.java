package com.example.goToba.repository;

import com.example.goToba.model.OrderDetail;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@Repository
public interface OrderDetailRepo extends ReactiveMongoRepository<OrderDetail,Integer> {

    Mono<OrderDetail> findFirstBySku(String sku);
    Mono<OrderDetail> findFirstByUserSku(String skUser);
}
