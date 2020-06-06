package com.example.goToba.service;

import com.example.goToba.model.MenuRestaurants;
import com.example.goToba.model.Restaurant;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import com.example.goToba.payload.request.RestaurantsRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
public interface RestaurantService {
    Flux<Restaurant> findAll();
    Mono<Restaurant> findBySku(String sku);
    Mono<Restaurant> addRestaurant(RestaurantsRequest restaurantsRequest, String sku);
    Mono<Restaurant> editRestaurant(RestaurantsRequest restaurantsRequest, String sku);
    Mono<MenuRestaurants> findByIdMenu(Integer idMenu);
    Mono<MenuRestaurants> addRestaurantMenu(MenuRestaurantsRequest menuRestaurantsRequest);
    Mono<MenuRestaurants> editRestaurantMenu(Integer idMenu, MenuRestaurantsRequest menuRestaurantsRequest);
    Mono<MenuRestaurants> deleteRestaurantMenu(Integer idMenu, MenuRestaurantsRequest menuRestaurantsRequest);
    Flux<MenuRestaurants> findMenuBySkuRestaurants(String sku);
}
