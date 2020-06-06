package com.example.goToba.controller;

import com.example.goToba.controller.route.TravellingScheduleControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.request.ScheduleRequest;
import com.example.goToba.service.TravellingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE)
public class TravellingScheduleController {
    @Autowired
    TravellingScheduleService travellingScheduleService;

    @GetMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_ALL)
    public Mono<ResponseEntity<?>> findAll(){
        return travellingScheduleService.findAll().
                collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(200,"OK",data));
                });
    }

    @GetMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_ALL)
    public Mono<ResponseEntity<?>> findAllBySku(@PathVariable String sku){
        return travellingScheduleService.findAll().
                filter(data -> data.getSkuCustomer().equals(sku)).
                collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(200,"OK",data));
                });
    }

    @GetMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_DETAIL)
    public Mono<ResponseEntity<?>> getDetailByScheduleId(@PathVariable String scheduleId){
        return travellingScheduleService.findByScheduleId(scheduleId).
                map(data -> {
                    return ResponseEntity.ok().body(new Response(200,"OK",data));
                });
    }

    @PutMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_UPDATE_DETAIL)
    public void getDetailByScheduleId(@PathVariable String scheduleId, @RequestBody ScheduleRequest scheduleRequest){

    }

}
