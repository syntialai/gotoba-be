package com.example.goToba.controller;

import com.example.goToba.controller.route.GaleryControllerRoute;
import com.example.goToba.payload.GetAllDataResponse;
import com.example.goToba.service.GaleryService;
import com.example.goToba.service.implement.GaleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Controller
@RequestMapping(GaleryControllerRoute.ROUTE_GALERY)
public class GaleryController {

    @Autowired
    GaleryServiceImpl galeryService;

    @GetMapping(GaleryControllerRoute.ROUTE_GALERY_All)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(new GetAllDataResponse("Success", galeryService.findAllGalery()));
    }


}
