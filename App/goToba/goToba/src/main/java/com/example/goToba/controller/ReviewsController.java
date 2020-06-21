package com.example.goToba.controller;

import com.example.goToba.controller.route.ReviewsControllerRoute;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.ReviewRequest;
import com.example.goToba.repository.RestaurantRepo;
import com.example.goToba.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
@RestController
@RequestMapping(ReviewsControllerRoute.ROUTE_FOR_REVIEWS)
public class ReviewsController {
    @Autowired
    ReviewsService reviewsService;

    @Autowired
    RestaurantRepo restaurantRepo;

    @GetMapping(ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA)
    public Mono<ResponseEntity<?>> findAllBySkuWisataOrRestaurants(@PathVariable String sku) {
        return reviewsService.findAllBySkuWisataOrRestaurants(sku).collectList().map(data -> {
            if (data.size() != 0) {
                return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
            }
            return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, ReviewsControllerRoute.ROUTE_FOR_REVIEWS + ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA));
        }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, ReviewsControllerRoute.ROUTE_FOR_REVIEWS + ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA)));
    }


    @GetMapping(ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA_AND_RATING)
    public Mono<ResponseEntity<?>> findAllBySkuWisataOrRestaurantsAndRating(@PathVariable String sku, @PathVariable Double rating) {
        return reviewsService.findAllBySkuWisataOrRestaurants(sku)
                .filter(data -> data.getRating() == rating)
                .collectList()
                .map(data -> {
                    if (data.size() != 0) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, ReviewsControllerRoute.ROUTE_FOR_REVIEWS + ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, ReviewsControllerRoute.ROUTE_FOR_REVIEWS + ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA)));
    }

    @GetMapping(ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA_AND_ID)
    public Mono<ResponseEntity<?>> findByReviewsById(@PathVariable String sku, Integer id){
        return reviewsService.findAllBySkuWisataOrRestaurants(sku)
                .filter(data -> data.getId() == id)
                .collectList()
                .map(data -> {
                    if (data.size() != 0) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, ReviewsControllerRoute.ROUTE_FOR_REVIEWS + ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, ReviewsControllerRoute.ROUTE_FOR_REVIEWS + ReviewsControllerRoute.ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA)));

    }

    @PostMapping(ReviewsControllerRoute.ROUTE_ADD_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA)
    public ResponseEntity<?> addReview(@PathVariable String sku, @PathVariable String userSku, @RequestBody ReviewRequest reviewRequest){
            reviewsService.addReviewRestaurants(sku,userSku,reviewRequest).subscribe();
        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS_CREATED,StaticResponseStatus.RESPONSE_STATUS_CREATED,reviewRequest));
    }
}
