package com.example.goToba.controller;

import com.example.goToba.controller.route.RestaurantControllerRoute;
import com.example.goToba.payload.MenuRestaurantsResponse;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.ResponseWithMessages;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.helper.Strings;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import com.example.goToba.payload.request.RestaurantsRequest;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.MenuRestaurantsService;
import com.example.goToba.service.RestaurantService;
import com.example.goToba.service.redisService.BistroRedisService;
import com.example.goToba.service.redisService.RestaurantRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

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

    @Autowired
    UsersRepo usersRepo;

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

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_RESTAURANT_BY_MERCHANT_SKU)
    public Mono<ResponseEntity<?>> findAllRestaurantsByMerchantSku(@PathVariable String merchantSku) {
        return restaurantService.findAll().filter(data -> data.getMerchantSku().equals(merchantSku)).collectList().
                map(data -> {
                    if (data.size() != 0) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(
                            new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_GET_RESTAURANT_BY_MERCHANT_SKU)
                    );
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
                    if (data.getMerchantSku() != null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(
                            new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "restaurant with sku " + sku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_GET_RESTAURANT_BY_SKU)
                    );
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(
                new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "restaurant with sku " + sku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_GET_RESTAURANT_BY_SKU))
        );
    }

    @PutMapping(RestaurantControllerRoute.ROUTE_EDIT_RESTAURANT_BY_SKU)
    public Mono<ResponseEntity<?>> editRestaurantsBySku(@PathVariable String sku, @RequestBody RestaurantsRequest restaurantsRequest) {
        return restaurantService.findBySku(sku)
                .map(data -> {
                    if (data.getMerchantSku() != null) {
                        restaurantService.editRestaurant(restaurantsRequest, sku).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, restaurantsRequest));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "restaurant with sku " + sku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_EDIT_RESTAURANT_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "restaurant with sku " + sku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_ADD_RESTAURANT_BY_SKU)));
    }

    @PostMapping(RestaurantControllerRoute.ROUTE_ADD_RESTAURANT_BY_SKU)
    public Mono<ResponseEntity<?>> addRestaurantsBySku(@PathVariable String merchantSku, @RequestBody RestaurantsRequest restaurantsRequest) {
        return usersRepo.findFirstBySku(merchantSku)
                .map(data -> {
                    if (data.getRoles() != null) {
                        restaurantService.addRestaurant(restaurantsRequest, merchantSku).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, restaurantsRequest));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_ADD_RESTAURANT_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_ADD_RESTAURANT_BY_SKU)));
    }

    @PostMapping(RestaurantControllerRoute.ROUTEADD_MENU_RESTAURANTS)
    public Mono<ResponseEntity<?>> addRestaurantsMenu(@PathVariable String merchantSku, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        return usersRepo.findFirstBySku(merchantSku)
                .map(data -> {
                    if (data.getRoles() != null) {
                        menuRestaurantsService.addRestaurantMenu(merchantSku, menuRestaurantsRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS_CREATED, StaticResponseStatus.RESPONSE_STATUS_CREATED, menuRestaurantsRequest));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTEADD_MENU_RESTAURANTS));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTEADD_MENU_RESTAURANTS)));
    }

    @PutMapping(RestaurantControllerRoute.ROUTE_EDIT_MENU_RESTAURANTS)
    public Mono<ResponseEntity<?>> editRestaurantsMenu(@PathVariable String merchantSku, @PathVariable Integer id, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        return menuRestaurantsService.findByIdMenu(id).
                map(data -> {
                    if (data.getMerchantSku() != null) {
                        menuRestaurantsService.editRestaurantMenu(merchantSku, id, menuRestaurantsRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "menu with id " + id, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_EDIT_MENU_RESTAURANTS));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "menu with id " + id, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_EDIT_MENU_RESTAURANTS)));
    }

    @DeleteMapping(RestaurantControllerRoute.ROUTE_DELETE_MENU_RESTAURANTS)
    public Mono<ResponseEntity<?>> deleteRestaurantsMenu(@PathVariable String merchantSku, @PathVariable Integer id, @RequestBody MenuRestaurantsRequest menuRestaurantsRequest) {
        menuRestaurantsService.deleteRestaurantMenu(merchantSku, id, menuRestaurantsRequest).subscribe();
        return menuRestaurantsService.findByIdMenu(id).
                map(data -> {
                    if (data.getMerchantSku() != null) {
                        menuRestaurantsService.deleteRestaurantMenu(merchantSku, id, menuRestaurantsRequest);
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "menu with sku " + merchantSku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_DELETE_MENU_RESTAURANTS));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "menu with sku " + merchantSku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_DELETE_MENU_RESTAURANTS)));
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_ALL_MENU_BY_SKU_RESTAURANTS)
    public Mono<ResponseEntity<?>> findMenuRestaurantBySkuRestaurants(@PathVariable String merchantSku) {
        return menuRestaurantsService.findAll()
                .filter(data -> data.getMerchantSku().equals(merchantSku))
                .filter(data -> data.getStatus().equals(Strings.STATUS_ACTIVE))
                .collectList().
                        map(data -> {
                            if (data.size() != 0) {
                                return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                            }
                            return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "menu with that merchant sku " + merchantSku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_GET_ALL_MENU_BY_SKU_RESTAURANTS));
                        }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "menu with that merchant sku " + merchantSku, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_GET_ALL_MENU_BY_SKU_RESTAURANTS)));
    }

    @GetMapping(RestaurantControllerRoute.ROUTE_GET_MENU_BY_ID)
    public Mono<ResponseEntity<?>> findMenuRestaurantById(@PathVariable Integer id) {
        return menuRestaurantsService.findByIdMenu(id)
                .map(data -> {
                    if (data.getMerchantSku() != null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "menu with that merchant id " + id, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_GET_MENU_BY_ID));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "menu with that merchant id " + id, RestaurantControllerRoute.ROUTE_RESTAURANT + RestaurantControllerRoute.ROUTE_GET_MENU_BY_ID)));


    }

}
