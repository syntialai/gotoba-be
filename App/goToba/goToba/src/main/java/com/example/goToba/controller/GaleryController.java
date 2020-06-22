package com.example.goToba.controller;

import com.example.goToba.controller.route.GaleryControllerRoute;
import com.example.goToba.payload.DefaultResponse;
import com.example.goToba.payload.DeleteResponse;
import com.example.goToba.payload.GaleryResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
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
    public Mono<ResponseEntity<GaleryResponse>> findBySku(@PathVariable String sku) {
        if (galeryServiceRedis.hasKey(sku)) {
            return galeryServiceRedis.findById(sku)
                    .map(
                            response -> ResponseEntity.ok().body(new GaleryResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, response))
                    );
        }
        return galeryService.findGaleryBySku(sku)
                .map(
                        response -> ResponseEntity.ok().body(new GaleryResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, response))
                );

    }

    @PostMapping(GaleryControllerRoute.ROUTE_GALERY_ADD_NEW)
    public ResponseEntity<?> addGalery(@RequestBody GaleryRequest request) throws IOException {
        galeryService.addNewFoto(request).subscribe();
        return ResponseEntity.ok(new GaleryResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, request));
    }

    @PutMapping(GaleryControllerRoute.ROUTE_GALERY_UPDATE_BY_SKU)
    public Mono<ResponseEntity<?>> updateBySku(@RequestBody GaleryRequest request, @PathVariable String sku) {
        galeryService.updateBySku(sku, request).subscribe();
        return galeryRepo.findFirstBySku(sku).
                map(data -> {
                    return ResponseEntity.ok(new GaleryResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
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
    public ResponseEntity<?> deleteBySku(@PathVariable String sku) {
        galeryService.suspendBySku(sku).subscribe();
        return ResponseEntity.ok(new DeleteResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS,StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseStatus.RESPONSE_STATUS_DELETE_SUCCESS_WISATA));
    }


}
