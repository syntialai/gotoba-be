package com.example.goToba.controller;

import com.example.goToba.controller.route.GaleryControllerRoute;
import com.example.goToba.model.Galery;
import com.example.goToba.payload.CreateResponse;
import com.example.goToba.payload.GaleryResponse;
import com.example.goToba.payload.GetAllDataResponse;
import com.example.goToba.payload.request.GaleryRequest;
import com.example.goToba.repository.GaleryRepo;
import com.example.goToba.service.GaleryService;
import com.example.goToba.service.implement.GaleryServiceImpl;
import com.example.goToba.service.redisService.GaleryServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

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
    public ResponseEntity<?> findAll() {


        Flux<Galery> data = galeryService.findAllGalery();
//        return ResponseEntity.ok(new GaleryResponse(200,"OK", data));
        return ResponseEntity.ok(galeryServiceRedis.findAll());
    }

    @GetMapping(GaleryControllerRoute.ROUTE_GALERY_FIND_BY_SKU)
    public ResponseEntity<?> findBySku(@PathVariable String sku) {
        System.out.println(galeryServiceRedis.findById(sku));
//        System.out.println(galeryRepo.findFirstBySku(sku));
        return ResponseEntity.ok(galeryServiceRedis.findById(sku));
    }

    @PostMapping(GaleryControllerRoute.ROUTE_GALERY_ADD_NEW)
    public ResponseEntity<?> addGalery(@RequestBody GaleryRequest request) {
        galeryService.addNewFoto(request).subscribe();
        return ResponseEntity.ok(new CreateResponse("201", "success", request));
    }

    @PutMapping(GaleryControllerRoute.ROUTE_GALERY_UPDATE_BY_SKU)
    public ResponseEntity<?> updateBySku(@RequestBody GaleryRequest request, @PathVariable String sku) {
        Mono.fromCallable(() -> request)
                .flatMap(string -> galeryService.updateBySku(sku, request))
                .subscribe();
        return ResponseEntity.ok(new CreateResponse("200", "success", request));
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
        galeryRepo.deleteBySku(sku).subscribe();
        return ResponseEntity.ok("Delete Success");
    }


}
