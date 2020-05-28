package com.example.goToba.controller;

import com.example.goToba.controller.route.RestaurantControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.ResponseWithMessages;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
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

    @PostMapping(RestaurantControllerRoute.ROUTEADD_MENU_RESTAURANTS)
    public ResponseEntity<?> addRestaurantsMenu( @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        restaurantService.addRestaurantMenu(menuRestaurantsRequest);
        return ResponseEntity.ok().body(new Response(200, "OK", restaurantService.addRestaurantMenu(menuRestaurantsRequest)));
    }

    @PutMapping(RestaurantControllerRoute.ROUTE_EDIT_MENU_RESTAURANTS)
    public ResponseEntity<?> editRestaurantsMenu(@PathVariable Integer id, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        restaurantService.editRestaurantMenu(id,menuRestaurantsRequest).subscribe();
        return ResponseEntity.ok().body(new Response(200, "OK", restaurantService.addRestaurantMenu(menuRestaurantsRequest)));
    }

    @PutMapping(RestaurantControllerRoute.ROUTE_DELETE_MENU_RESTAURANTS)
    public ResponseEntity<?> deleteRestaurantsMenu(@PathVariable Integer id, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        restaurantService.deleteRestaurantMenu(id,menuRestaurantsRequest).subscribe();
        return ResponseEntity.ok().body(new ResponseWithMessages(200, "OK", restaurantService.findByIdMenu(id),"Delete Sukses"));
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_ALL_MENU_BY_SKU_RESTAURANTS)
    public ResponseEntity<?> findMenuRestaurantBySkuRestaurants(@PathVariable String skuRestaurants) {
        restaurantService.findMenuBySkuRestaurants(skuRestaurants).subscribe();
        return ResponseEntity.ok().body(restaurantService.findMenuBySkuRestaurants(skuRestaurants).subscribe());
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_MENU_BY_ID)
    public ResponseEntity<?> findMenuRestaurantById(@PathVariable Integer id) {
        restaurantService.findByIdMenu(id).subscribe();
        return ResponseEntity.ok().body(restaurantService.findByIdMenu(id).subscribe());
    }

}
