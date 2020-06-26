package com.example.goToba.controller;

import com.example.goToba.controller.route.NearByLocationControllerRoute;
import com.example.goToba.repository.RestaurantRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.implement.NearByLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/06/2020.
 */
@RestController
@RequestMapping(NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION)
public class NearByLocationController {
    @Autowired
    WisataRepo wisataRepo;

    @Autowired
    NearByLocationServiceImpl nearByLocationService;

    @GetMapping(NearByLocationControllerRoute.ROUTE_TO_NEAR_BY_LOCATION_WISATA)
    public Mono<ResponseEntity<?>> findNear(@PathVariable Double longitude, @PathVariable Double lat) {
        return wisataRepo.findAll()
                .filter(data -> nearByLocationService.distance(lat, Double.parseDouble(data.getLatitude()), longitude, Double.parseDouble(data.getLongitude())) <= 500000)
                .collectList()
                .map(data -> {
                    return ResponseEntity.ok(data);
                });

    }
}
