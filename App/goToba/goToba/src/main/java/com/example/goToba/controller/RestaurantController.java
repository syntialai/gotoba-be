package com.example.goToba.controller;

import com.example.goToba.controller.route.RestaurantControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.ResponseWithMessages;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseStatus;
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
    public Mono<ResponseEntity<?>> findAllBistroTypes() {
        return restaurantService.findAll().collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_RESTAURANT_All)
    public Mono<ResponseEntity<?>> findAllRestaurants() {
        return restaurantService.findAll().collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_RESTAURANT_BY_SKU)
    public Mono<ResponseEntity<?>> findRestaurantsBySku(@PathVariable String sku) {
        if (restaurantRedisService.hasKey(sku)) {
            return restaurantRedisService.findById(sku).
                    map(data -> {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    });
        }
        return restaurantService.findBySku(sku).
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });

    }

    @PostMapping(RestaurantControllerRoute.ROUTE_ADD_RESTAURANT)
    public ResponseEntity<?> editRestaurantsBySku(@PathVariable String sku, @RequestBody RestaurantsRequest restaurantsRequest) {
        restaurantService.editRestaurant(restaurantsRequest, sku).subscribe();
        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, restaurantService.editRestaurant(restaurantsRequest, sku).subscribe()));
    }

    @PutMapping(RestaurantControllerRoute.ROUTE_EDIT_RESTAURANT_BY_SKU)
    public ResponseEntity<?> addRestaurantsBySku(@PathVariable String sku, @RequestBody RestaurantsRequest restaurantsRequest) {
        restaurantService.addRestaurant(restaurantsRequest, sku).subscribe();
        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, restaurantsRequest));
    }

    @PostMapping(RestaurantControllerRoute.ROUTEADD_MENU_RESTAURANTS)
    public ResponseEntity<?> addRestaurantsMenu(@RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        restaurantService.addRestaurantMenu(menuRestaurantsRequest);
        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK,restaurantService.addRestaurantMenu(menuRestaurantsRequest)));
    }

    @PutMapping(RestaurantControllerRoute.ROUTE_EDIT_MENU_RESTAURANTS)
    public ResponseEntity<?> editRestaurantsMenu(@PathVariable Integer id, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        restaurantService.editRestaurantMenu(id, menuRestaurantsRequest).subscribe();
        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, restaurantService.addRestaurantMenu(menuRestaurantsRequest)));
    }

    @PutMapping(RestaurantControllerRoute.ROUTE_DELETE_MENU_RESTAURANTS)
    public ResponseEntity<?> deleteRestaurantsMenu(@PathVariable Integer id, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        restaurantService.deleteRestaurantMenu(id, menuRestaurantsRequest).subscribe();
        return ResponseEntity.ok().body(new ResponseWithMessages(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, restaurantService.findByIdMenu(id), "Delete Sukses"));
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
