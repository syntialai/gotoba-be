package com.example.goToba.service.redisService;

import com.example.goToba.model.Restaurant;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
public interface RestaurantRedisService<T> {
    void add(Restaurant restaurant);
    Mono<T> findById(String id);
    List<Restaurant> findAll();
    Boolean hasKey(String key);
    void delete(String key);
}
