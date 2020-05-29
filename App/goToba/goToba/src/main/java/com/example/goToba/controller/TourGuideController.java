package com.example.goToba.controller;

import com.example.goToba.controller.route.RestaurantControllerRoute;
import com.example.goToba.controller.route.TourGuideControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.request.TourGuideRequest;
import com.example.goToba.service.TourGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> findAllTourGuide(){
        return ResponseEntity.ok().body(tourGuideService.findAll());
    }

    @GetMapping(TourGuideControllerRoute.ROUTE_TO_TOUR_GUIDE_GET_BY_SKU)
    public ResponseEntity<?> findTourGuideBySku(@PathVariable String sku){
        return ResponseEntity.ok().body(new Response(200,"OK",tourGuideService.findBySku(sku)));
    }

    @GetMapping(TourGuideControllerRoute.ROUTE_TO_ADD_TOUR_GUIDE)
    public ResponseEntity<?> addTourGuide(@RequestBody TourGuideRequest tourGuideRequest){
        tourGuideService.addTourGuide(tourGuideRequest).subscribe();
        return ResponseEntity.ok().body(new Response(2000,"OK",tourGuideService.findByName(tourGuideRequest.getName())));
    }
}
