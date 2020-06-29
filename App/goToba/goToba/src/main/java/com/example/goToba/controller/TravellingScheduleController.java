package com.example.goToba.controller;

import com.example.goToba.controller.route.TravellingScheduleControllerRoute;
import com.example.goToba.payload.ActionResponses;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.ScheduleRequest;
import com.example.goToba.service.TravellingScheduleService;
import com.example.goToba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE)
public class TravellingScheduleController {

    @Autowired
    TravellingScheduleService travellingScheduleService;

    @Autowired
    UserService userService;

    @GetMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_ALL)
    public Mono<ResponseEntity<?>> findAll() {
        return travellingScheduleService.findAll().
                collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(200, "OK", data));
                });
    }

    @GetMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_ALL)
    public Mono<ResponseEntity<?>> findAllBySku(@PathVariable String userSku) {
        return travellingScheduleService.findAll().
                filter(data -> data.getUserSku().equals(userSku)).
                collectList().
                map(data -> {
                    if(data.size()!=0) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND,StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY_SCHEDULE, TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE+TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_ALL));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND,StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND,StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY_SCHEDULE, TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE+TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_ALL)));
    }

    @GetMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_DETAIL)
    public Mono<ResponseEntity<?>> getDetailByScheduleId(@PathVariable Integer scheduleId) {
        return Mono.fromCallable(() -> travellingScheduleService.findByScheduleId(scheduleId))
                .flatMap(data -> travellingScheduleService.findByScheduleId(scheduleId))
                .map(data -> {
                    if(data.getUserSku()!=null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "Schedule with that id.", TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE + TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_DETAIL));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "Schedule with that id.", TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE + TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_GET_DETAIL)));

    }


    @PostMapping(TravellingScheduleControllerRoute.ROUTE_ADD_TRAVELLING_SCEDULE)
    public Mono<ResponseEntity<?>> addScheduleBySku(@PathVariable String userSku, @RequestBody ScheduleRequest scheduleRequest) {
        return Mono.fromCallable(() -> scheduleRequest)
                .flatMap(data -> userService.findFirstBySku(userSku))
                .map(data -> {
                    if (data.getUsername() != null) {
                        travellingScheduleService.addBySku(userSku, scheduleRequest).subscribe();
                        return ResponseEntity.ok().body(new ActionResponses(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_ADD_TRAVELLING_SCHEDULE));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "User with that Sku.", TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE + TravellingScheduleControllerRoute.ROUTE_ADD_TRAVELLING_SCEDULE));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "User with that Sku.", TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE + TravellingScheduleControllerRoute.ROUTE_ADD_TRAVELLING_SCEDULE)));
    }

    @PutMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_UPDATE_DETAIL)
    public Mono<ResponseEntity<?>> editScheduleBySku(@PathVariable Integer id, @RequestBody ScheduleRequest scheduleRequest) {

        return Mono.fromCallable(() -> travellingScheduleService.findByScheduleId(id))
                .flatMap(data -> travellingScheduleService.findByScheduleId(id))
                .map(data -> {
                    if (data.getUserSku() != null) {
                        travellingScheduleService.editById(id, scheduleRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "Schedule with that id.", TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE + TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_UPDATE_DETAIL));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "Schedule with that id.", TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE + TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_UPDATE_DETAIL)));
    }

    @DeleteMapping(TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_DELETE_DETAIL)
    public Mono<ResponseEntity<?>> deleteScheduleBySku(@PathVariable Integer id) {
        return Mono.fromCallable(() -> id)
                .flatMap(data -> travellingScheduleService.findByScheduleId(id))
                .map(data -> {
                    if (data.getUserSku() != null) {
                        travellingScheduleService.deleteById(id).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_DELETE_SCHEDULE + id));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "Schedule with that id.", TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE + TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_DELETE_DETAIL));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "Schedule with that id.", TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE + TravellingScheduleControllerRoute.ROUTE_TRAVELLING_SCEDULE_DELETE_DETAIL)));


    }

}
