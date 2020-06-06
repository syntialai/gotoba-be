package com.example.goToba.controller;

import com.example.goToba.controller.route.TourGuideControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.TourGuideRequest;
import com.example.goToba.service.TourGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

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
                map(data ->{
                    return  ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK,data));
                });
    }

    @GetMapping(TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE_GET_BY_SKU)
    public Mono<ResponseEntity<?>> findTourGuideBySku(@PathVariable String sku) {
        return tourGuideService.findBySku(sku).
                map(
                        data -> ResponseEntity.ok().body(new Response(200, "OK", data))
                );
    }

    @GetMapping(TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE_GET_BY_Name)
    public Mono<ResponseEntity<?>> findTourGuideByName(@PathVariable String sku) {
        return tourGuideService.findByName(sku).
                map(
                        data -> ResponseEntity.ok().body(new Response(200, "OK", data))
                );
    }

    @PostMapping(TourGuideControllerRoute.ROUTE_TO_ADD_TOUR_GUIDE)
    public Mono<ResponseEntity<?>> addTourGuide(@RequestBody TourGuideRequest tourGuideRequest) {

        return tourGuideService.addTourGuide(tourGuideRequest).
                flatMap(
                        data -> tourGuideService.findByName(tourGuideRequest.getName())
                ).map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS,StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @PutMapping(TourGuideControllerRoute.ROUTE_TO_EDIT_TOUR_GUIDE)
    public Mono<ResponseEntity<?>> editTourGuide(@PathVariable String sku, @RequestBody TourGuideRequest tourGuideRequest) {
        return Mono.fromCallable(() -> tourGuideService.editTourGuide(tourGuideRequest, sku).subscribe()).
                flatMap(
                        data -> tourGuideService.findBySku(sku)
                ).
                map(
                        data -> {
                            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                        }
                );
    }
}
