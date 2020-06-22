package com.example.goToba.controller;

import com.example.goToba.controller.route.GaleryControllerRoute;
import com.example.goToba.payload.*;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.GaleryRequest;
import com.example.goToba.repository.GaleryRepo;
import com.example.goToba.service.implement.GaleryServiceImpl;
import com.example.goToba.service.redisService.GaleryServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Controller
@RequestMapping(GaleryControllerRoute.ROUTE_GALERY)
public class GaleryController {

    @Autowired
    GaleryServiceImpl galeryService;

    @Autowired
    GaleryRepo galeryRepo;

    @Autowired
    GaleryServiceRedis galeryServiceRedis;

    private HashOperations hashOperations;

    @GetMapping(GaleryControllerRoute.ROUTE_GALERY_All)
    public Mono<ResponseEntity<?>> findAll() {

        return galeryService.findAllGalery().collectList().map(data -> {
            return ResponseEntity.ok(new GaleryResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });

    }

    @GetMapping(GaleryControllerRoute.ROUTE_GALERY_FIND_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        if (galeryServiceRedis.hasKey(sku)) {
            return galeryServiceRedis.findById(sku)
                    .map(response -> ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, response)));
        }
        return galeryService.findGaleryBySku(sku)
                .map(response -> {
                    if(response.getSku()!=null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, response));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "photo with sku " + sku, GaleryControllerRoute.ROUTE_GALERY + GaleryControllerRoute.ROUTE_GALERY_FIND_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "photo with sku " + sku, GaleryControllerRoute.ROUTE_GALERY + GaleryControllerRoute.ROUTE_GALERY_FIND_BY_SKU)));

    }

    @PostMapping(GaleryControllerRoute.ROUTE_GALERY_ADD_NEW)
    public Mono<ResponseEntity<?>> addGalery(@RequestBody GaleryRequest request) throws IOException {
        return Mono.fromCallable(() -> request)
                .doOnNext(req -> {
                    try {
                        galeryService.addNewFoto(req).subscribe();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .flatMap(data -> galeryService.findFirstByTitle(request.getTitle()))
                .map(data -> {
                    System.out.println(data);
                    return ResponseEntity.ok(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });


    }

    @PutMapping(GaleryControllerRoute.ROUTE_GALERY_UPDATE_BY_SKU)
    public Mono<ResponseEntity<?>> updateBySku(@RequestBody GaleryRequest request, @PathVariable String sku) {

        return Mono.fromCallable(() -> request)
                .doOnNext(req -> galeryService.updateBySku(sku, request).subscribe())
                .flatMap(data -> galeryService.findGaleryBySku(sku))
                .map(data -> {
                    System.out.println(data);
                    if(data.getSku()!=null) {
                        return ResponseEntity.ok(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "photo with sku " + sku, GaleryControllerRoute.ROUTE_GALERY + GaleryControllerRoute.ROUTE_GALERY_UPDATE_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "photo with sku " + sku, GaleryControllerRoute.ROUTE_GALERY + GaleryControllerRoute.ROUTE_GALERY_UPDATE_BY_SKU)));

    }

    @PutMapping(GaleryControllerRoute.ROUTE_GALERY_SUSPEND_BY_SKU)
    public ResponseEntity<?> suspendBySku(@PathVariable String sku) {
        Mono.fromCallable(() -> sku)
                .flatMap(string -> galeryService.suspendBySku(sku))
                .subscribe();
        return ResponseEntity.ok("Suspend Success");
    }

    @PutMapping(GaleryControllerRoute.ROUTE_GALERY_ACTIVATE_BY_SKU)
    public ResponseEntity<?> activate(@PathVariable String sku) {
        Mono.fromCallable(() -> sku)
                .flatMap(string -> galeryService.activateBySku(sku))
                .subscribe();
        return ResponseEntity.ok("Suspend Success");
    }

    @DeleteMapping(GaleryControllerRoute.ROUTE_GALERY_DELETE_BY_SKU)
    public Mono<ResponseEntity<?>> deleteBySku(@PathVariable String sku) {
        return Mono.fromCallable(() -> sku)
                .doOnNext(data -> galeryService.suspendBySku(sku).subscribe())
                .flatMap(data -> galeryService.findGaleryBySku(sku))
                .map(data -> {
                    if(data.getSku()!=null){
                        return ResponseEntity.ok(new DeleteResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS,StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseStatus.RESPONSE_STATUS_DELETE_SUCCESS_WISATA));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "photo with sku " + sku, GaleryControllerRoute.ROUTE_GALERY + GaleryControllerRoute.ROUTE_GALERY_DELETE_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "photo with sku " + sku, GaleryControllerRoute.ROUTE_GALERY + GaleryControllerRoute.ROUTE_GALERY_DELETE_BY_SKU)));


    }


}
