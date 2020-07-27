package com.example.goToba.controller;

import com.example.goToba.controller.route.TourGuideControllerRoute;
import com.example.goToba.payload.DeleteResponse;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.TourGuideRequest;
import com.example.goToba.service.TourGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
@CrossOrigin
@RestController
@RequestMapping(TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE)
public class TourGuideController {

    @Autowired
    TourGuideService tourGuideService;

    @GetMapping(TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE_GET_ALL)
    public Mono<ResponseEntity<?>> findAllTourGuide() {
        return tourGuideService.findAll().collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE_GET_BY_SKU)
    public Mono<ResponseEntity<?>> findTourGuideBySku(@PathVariable String sku) {
        return tourGuideService.findBySku(sku).
                map(data -> {
                    if (data.getId() != null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "tour guide with sku " + sku, TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE + TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE_GET_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "tour guide with sku " + sku, TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE + TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE_GET_BY_SKU)));
    }

    @GetMapping(TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE_GET_BY_Name)
    public Mono<ResponseEntity<?>> findTourGuideByName(@PathVariable String sku) {
        return tourGuideService.findByName(sku).
                map(data -> ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data)));
    }

    @PostMapping(TourGuideControllerRoute.ROUTE_TO_ADD_TOUR_GUIDE)
    public Mono<ResponseEntity<?>> addTourGuide(@RequestBody TourGuideRequest tourGuideRequest) {
        return Mono.fromCallable(() -> tourGuideRequest)
                .doOnNext(data -> tourGuideService.addTourGuide(data).subscribe())
                .doOnSuccess(data -> tourGuideService.findByName(tourGuideRequest.getName()))
                .map(data -> {
                    System.out.println(data);
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS_CREATED, StaticResponseStatus.RESPONSE_STATUS_CREATED, data));
                });
    }

    @PutMapping(TourGuideControllerRoute.ROUTE_TO_EDIT_TOUR_GUIDE)
    public Mono<ResponseEntity<?>> editTourGuide(@PathVariable String sku, @RequestBody TourGuideRequest tourGuideRequest) {
        return Mono.fromCallable(() -> tourGuideService.editTourGuide(tourGuideRequest, sku).subscribe())
                .doOnNext(data -> tourGuideService.editTourGuide(tourGuideRequest, sku).subscribe())
                .flatMap(data -> tourGuideService.findBySku(sku))
                .map(data -> {
                    if (data.getSku() != null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "tour guide with sku " + sku, TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE + TourGuideControllerRoute.ROUTE_TO_DELETE_TOUR_GUIDE));
                })
                .defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "tour guide with sku " + sku, TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE + TourGuideControllerRoute.ROUTE_TO_DELETE_TOUR_GUIDE)));

    }

    @DeleteMapping(TourGuideControllerRoute.ROUTE_TO_DELETE_TOUR_GUIDE)
    public Mono<ResponseEntity<?>> deleteTourGuideBySku(@PathVariable String sku, @RequestBody TourGuideRequest tourGuideRequest) {
        return tourGuideService.findBySku(sku)
                .map(data -> {
                    if (data != null) {
                        tourGuideService.deleteTourGuide(sku).subscribe();
                        return ResponseEntity.ok(new DeleteResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseStatus.RESPONSE_STATUS_DELETE_SUCCESS));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "tour guide with sku " + sku, TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE + TourGuideControllerRoute.ROUTE_TO_DELETE_TOUR_GUIDE));
                })
                .defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "tour guide with sku " + sku, TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE + TourGuideControllerRoute.ROUTE_TO_DELETE_TOUR_GUIDE)));
    }
}
