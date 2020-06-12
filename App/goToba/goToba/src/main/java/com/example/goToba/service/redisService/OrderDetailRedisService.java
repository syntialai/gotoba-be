package com.example.goToba.service.redisService;

import com.example.goToba.model.OrderDetail;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
public interface OrderDetailRedisService<T> {
    void add(OrderDetail orderDetail);
    Mono<T> findById(String id);
    List<OrderDetail> findAll();
    Boolean hasKey(String key);
    void delete(String key);
}
