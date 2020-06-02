package com.example.goToba.controller;

import com.example.goToba.controller.route.TravellingScheduleControllerRoute;
import com.example.goToba.service.TravellingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE)
public class TravellingScheduleController {
    @Autowired
    TravellingScheduleService travellingScheduleService;

}
