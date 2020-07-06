package com.example.goToba.controller;

import com.example.goToba.controller.route.NearByLocationControllerRoute;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.repository.RestaurantRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.NearByLocationService;
import com.example.goToba.service.implement.NearByLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/06/2020.
 */
@RestController
@RequestMapping(NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION)
public class NearByLocationController {
    @Autowired
    WisataRepo wisataRepo;

    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    NearByLocationService nearByLocationService;

    @GetMapping(NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION_WISATA)
    public Mono<ResponseEntity<?>> findNearWisata(@PathVariable Double longitude, @PathVariable Double lat) {
        return wisataRepo.findAll()
                .filter(data -> nearByLocationService.distance(lat, Double.parseDouble(data.getLatitude()), longitude, Double.parseDouble(data.getLongitude())) <= 500000)
                .collectList()
                .map(data -> {
                    if (data.size() != 0) {
                        return ResponseEntity.ok(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(),StaticResponseCode.RESPONSE_CODE_NOT_FOUND,StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY_NEAR_BY_LOCATION_RESTAURANT,NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION + NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION_WISATA));
                }).defaultIfEmpty(ResponseEntity.ok(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(),StaticResponseCode.RESPONSE_CODE_NOT_FOUND,StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY_NEAR_BY_LOCATION_RESTAURANT,NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION + NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION_WISATA)));
    }

    @GetMapping(NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION_RESTAURANTS)
    public Mono<ResponseEntity<?>> findNearByLocationRestaurant(@PathVariable Double longitude, @PathVariable Double lat) {
        return restaurantRepo.findAll()
                .filter(data -> nearByLocationService.distance(lat, Double.parseDouble(data.getLatitude()), longitude, Double.parseDouble(data.getLongitude())) <= 500000)
                .collectList()
                .map(data -> {
                    if (data.size()!=0) {
                        return ResponseEntity.ok(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(),StaticResponseCode.RESPONSE_CODE_NOT_FOUND,StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY_NEAR_BY_LOCATION_RESTAURANT,NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION + NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION_RESTAURANTS));
                }).defaultIfEmpty(ResponseEntity.ok(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(),StaticResponseCode.RESPONSE_CODE_NOT_FOUND,StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY_NEAR_BY_LOCATION_RESTAURANT,NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION + NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION_RESTAURANTS)));
    }
}
