package com.example.goToba.controller;

import com.example.goToba.controller.route.RestaurantControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.request.RestaurantsRequest;
import com.example.goToba.service.RestaurantService;
import com.example.goToba.service.redisService.BistroRedisService;
import com.example.goToba.service.redisService.RestaurantRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@CrossOrigin
@RestController
@RequestMapping(RestaurantControllerRoute.ROUTE_RESTAURANT)
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RestaurantRedisService restaurantRedisService;

    @Autowired
    BistroRedisService bistroRedisService;

    @GetMapping(RestaurantControllerRoute.ROUTE_RESTAURANT_BISTRO_TYPES)
    public ResponseEntity<?> findAllBistroTypes() {
        return ResponseEntity.ok().body(new Response(200, "OK", bistroRedisService.findAll()));
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_RESTAURANT_All)
    public ResponseEntity<?> findAllRestaurants() {
        return ResponseEntity.ok().body(new Response(200, "OK", restaurantRedisService.findAll()));
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_RESTAURANT_BY_SKU)
    public ResponseEntity<?> findRestaurantsBySku(@PathVariable String sku) {
        if (restaurantRedisService.hasKey(sku)) {
            return ResponseEntity.ok().body(new Response(200, "OK", restaurantRedisService.findById(sku)));
        }
        return ResponseEntity.ok().body(new Response(200, "OK", restaurantService.findBySku(sku)));
    }

    @PostMapping(RestaurantControllerRoute.ROUTE_ADD_RESTAURANT_BY_SKU)
    public ResponseEntity<?> findRestaurantsBySku(@PathVariable String sku, @RequestBody RestaurantsRequest restaurantsRequest) {
        restaurantService.addRestaurant(restaurantsRequest, sku);
        return ResponseEntity.ok().body(new Response(200, "OK", restaurantService.addRestaurant(restaurantsRequest, sku)));
    }

}
