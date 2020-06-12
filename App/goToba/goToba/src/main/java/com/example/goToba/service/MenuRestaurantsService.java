package com.example.goToba.service;

import com.example.goToba.model.MenuRestaurants;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/06/2020.
 */
public interface MenuRestaurantsService {
    Mono<MenuRestaurants> findByIdMenu(Integer idMenu);
    Mono<MenuRestaurants> findByNama(String  nama);
    Mono<MenuRestaurants> addRestaurantMenu(String skuResto,MenuRestaurantsRequest menuRestaurantsRequest);
    Mono<MenuRestaurants> editRestaurantMenu(String sku,Integer idMenu, MenuRestaurantsRequest menuRestaurantsRequest);
    Mono<MenuRestaurants> deleteRestaurantMenu(String sku, Integer idMenu, MenuRestaurantsRequest menuRestaurantsRequest);
    Flux<MenuRestaurants> findAll();
}
