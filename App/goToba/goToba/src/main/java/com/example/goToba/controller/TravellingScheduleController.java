package com.example.goToba.controller;

import com.example.goToba.controller.route.TravellingScheduleControllerRoute;
import com.example.goToba.payload.ActionResponses;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
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
    public Mono<ResponseEntity<?>> findAll() {
        return travellingScheduleService.findAll().
                collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(200, "OK", data));
                });
    }

    @GetMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_ALL)
    public Mono<ResponseEntity<?>> findAllBySku(@PathVariable String sku) {
        return travellingScheduleService.findAll().
                filter(data -> data.getUserSku().equals(sku)).
                collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(200, "OK", data));
                });
    }

    @GetMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_DETAIL)
    public Mono<ResponseEntity<?>> getDetailByScheduleId(@PathVariable Integer scheduleId) {
        return travellingScheduleService.findByScheduleId(scheduleId).
                map(data -> {
                    return ResponseEntity.ok().body(new Response(200, "OK", data));
                });
    }


    @PostMapping(TravellingScheduleControllerRoute.ROUTE_ADD_TRAVELLING_SCEDULE)
    public ResponseEntity<?> addScheduleBySku(@PathVariable String sku, @RequestBody ScheduleRequest scheduleRequest) {
        travellingScheduleService.addBySku(sku, scheduleRequest).subscribe();
        return ResponseEntity.ok().body(new ActionResponses(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_ADD_TRAVELLING_SCHEDULE));
    }

    @PutMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_UPDATE_DETAIL)
    public Mono<ResponseEntity<?>> editScheduleBySku(@PathVariable Integer id, @RequestBody ScheduleRequest scheduleRequest) {

        return Mono.fromCallable(() -> travellingScheduleService.editById(id, scheduleRequest).subscribe()).
                flatMap(
                        data -> travellingScheduleService.findByScheduleId(id)
                ).
                map(
                        data -> {
                            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                        }
                );
    }

    @DeleteMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_DELETE_DETAIL)
    public ResponseEntity<?> deleteScheduleBySku(@PathVariable Integer id) {
        travellingScheduleService.deleteById(id).subscribe();
        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_DELETE_SCHEDULE+id));

    }

}
