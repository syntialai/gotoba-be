package com.example.goToba.service;

import com.example.goToba.model.MenuRestaurants;
import com.example.goToba.model.Restaurant;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import com.example.goToba.payload.request.RestaurantsRequest;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
public interface RestaurantService {
    Mono<Restaurant> findBySku(String sku);
    Mono<Restaurant> addRestaurant(RestaurantsRequest restaurantsRequest, String sku);
    Mono<MenuRestaurants> addRestaurantMenu(MenuRestaurantsRequest menuRestaurantsRequest);
    Mono<MenuRestaurants> editRestaurantMenu(Integer idMenu, MenuRestaurantsRequest menuRestaurantsRequest);
}
