package com.example.goToba.repository;

import com.example.goToba.model.MenuRestaurants;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@Repository
public interface MenuRestaurantsRepo extends ReactiveMongoRepository<MenuRestaurants,Integer> {
    public Mono<Void> deleteByIdAndRestaurantSku(Integer id,String sku);
    public Flux<MenuRestaurants> findAllByRestaurantSku(String skuRestaurants);
    public Mono<MenuRestaurants> findFirstByName(String name);
}
