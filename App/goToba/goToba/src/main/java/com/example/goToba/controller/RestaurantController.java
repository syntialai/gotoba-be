package com.example.goToba.controller;

import com.example.goToba.controller.route.RestaurantControllerRoute;
import com.example.goToba.payload.MenuRestaurantsResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.ResponseWithMessages;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import com.example.goToba.payload.request.RestaurantsRequest;
import com.example.goToba.service.MenuRestaurantsService;
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
    MenuRestaurantsService menuRestaurantsService;

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

    @PutMapping(RestaurantControllerRoute.ROUTE_EDIT_RESTAURANT_BY_SKU)
    public ResponseEntity<?> editRestaurantsBySku(@PathVariable String sku, @RequestBody RestaurantsRequest restaurantsRequest) {
        restaurantService.editRestaurant(restaurantsRequest, sku).subscribe();
        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, restaurantsRequest));
    }

    @PostMapping(RestaurantControllerRoute.ROUTE_ADD_RESTAURANT_BY_SKU)
    public ResponseEntity<?> addRestaurantsBySku(@PathVariable String skuMerchant, @RequestBody RestaurantsRequest restaurantsRequest) {
        restaurantService.addRestaurant(restaurantsRequest, skuMerchant).subscribe();
        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, restaurantsRequest));
    }

    @PostMapping(RestaurantControllerRoute.ROUTEADD_MENU_RESTAURANTS)
    public Mono<ResponseEntity<?>> addRestaurantsMenu(@PathVariable String sku,@RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        return menuRestaurantsService.addRestaurantMenu(sku,menuRestaurantsRequest).
                flatMap(
                        data -> menuRestaurantsService.findByNama(menuRestaurantsRequest.getName())
                ).map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });
    }

    @PutMapping(RestaurantControllerRoute.ROUTE_EDIT_MENU_RESTAURANTS)
    public Mono<ResponseEntity<?>> editRestaurantsMenu(@PathVariable String sku, @PathVariable Integer id, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        menuRestaurantsService.editRestaurantMenu(sku,id, menuRestaurantsRequest).subscribe();
        return menuRestaurantsService.editRestaurantMenu(sku,id, menuRestaurantsRequest).
                flatMap(
                        data -> menuRestaurantsService.findByIdMenu(id)
                ).map(data -> {
            return ResponseEntity.ok().body(new MenuRestaurantsResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data, StaticResponseMessages.RESPONSE_MESSAGES_FOR_UPDATE_SUKSES));
        });
    }

    @DeleteMapping(RestaurantControllerRoute.ROUTE_DELETE_MENU_RESTAURANTS)
    public Mono<ResponseEntity<?>> deleteRestaurantsMenu(@PathVariable String sku, @PathVariable Integer id, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        menuRestaurantsService.deleteRestaurantMenu(sku, id, menuRestaurantsRequest).subscribe();
        return menuRestaurantsService.deleteRestaurantMenu(sku, id, menuRestaurantsRequest).
                flatMap(
                        data -> menuRestaurantsService.findByIdMenu(id)
                ).map(data -> {
            return ResponseEntity.ok().body(new MenuRestaurantsResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data, StaticResponseMessages.RESPONSE_MESSAGES_FOR_DELETE_SUKSES));
        });
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_ALL_MENU_BY_SKU_RESTAURANTS)
    public Mono<ResponseEntity<?>> findMenuRestaurantBySkuRestaurants(@PathVariable String sku) {
        return menuRestaurantsService.findAll().
                filter(data -> data.getRestaurantSku().equals(sku))
                .filter(data -> data.getStatus().equals("1"))
                .collectList().
                        map(data -> {
                            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                        });

    }

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_MENU_BY_ID)
    public Mono<ResponseEntity<?>> findMenuRestaurantById(@PathVariable Integer id) {
        return menuRestaurantsService.findByIdMenu(id).map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });

    }

}
