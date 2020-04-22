package com.example.goToba.controller;

import com.example.goToba.controller.route.GaleryControllerRoute;
import com.example.goToba.model.Galery;
import com.example.goToba.payload.CreateResponse;
import com.example.goToba.payload.GetAllDataResponse;
import com.example.goToba.payload.request.GaleryRequest;
import com.example.goToba.repository.GaleryRepo;
import com.example.goToba.service.GaleryService;
import com.example.goToba.service.implement.GaleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

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

    @GetMapping(GaleryControllerRoute.ROUTE_GALERY_All)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(galeryService.findAllGalery());
    }

    @PostMapping(GaleryControllerRoute.ROUTE_GALERY_ADD_NEW)
    public ResponseEntity<?> addGalery(@RequestBody GaleryRequest request) {
        galeryService.addNewFoto(request).subscribe();
        galeryService.skuGenerator(request.getName());
        return ResponseEntity.ok(new CreateResponse("201", "success", request));
    }

    @GetMapping(GaleryControllerRoute.ROUTE_GALERY_FIND_BY_SKU)
    public ResponseEntity<Mono<Galery>> findBySku(@PathVariable String sku) {
        System.out.println(galeryRepo.findFirstBySku(sku));
        return ResponseEntity.ok(galeryRepo.findFirstBySku(sku));
    }


    @PutMapping(GaleryControllerRoute.ROUTE_GALERY_UPDATE_BY_SKU)
    public ResponseEntity<?> updateBySku(@RequestBody GaleryRequest request, @PathVariable String sku) {
        Mono.fromCallable(() -> request)
                .flatMap(string -> galeryService.updateBySku(sku, request))
                .doOnNext( i-> System.out.println(sku))
                .subscribe();
        return ResponseEntity.ok(new CreateResponse("200", "success", request));
    }
    @PutMapping(GaleryControllerRoute.ROUTE_GALERY_SUSPEND_BY_SKU)
    public ResponseEntity<?> suspendBySku(@RequestBody GaleryRequest request, @PathVariable String sku) {
        Mono.fromCallable(() -> sku)
                .flatMap(string -> galeryService.updateBySku(sku, request))
                .doOnNext( i-> System.out.println(sku))
                .subscribe();
        return ResponseEntity.ok(new CreateResponse("200", "success", request));
    }

    @DeleteMapping(GaleryControllerRoute.ROUTE_GALERY_DELETE_BY_SKU)
    public ResponseEntity<?> deletBySku(@PathVariable String sku){
        galeryRepo.deleteBySku(sku).subscribe();
        return ResponseEntity.ok("Delete Success");
    }


}
