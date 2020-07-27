package com.example.goToba.controller;


import com.example.goToba.controller.route.UserControllerRoute;
import com.example.goToba.payload.AuthenticationResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.payload.request.UpdateUserRequest;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@RestController
@RequestMapping(UserControllerRoute.ROUTE_AUTH)
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    SequenceUsersRepo sequenceUsersRepo;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @GetMapping(UserControllerRoute.ROUTE_USER_FIND_ALL)
    public Mono<ResponseEntity<?>> findAll() {
        return usersRepo.findAll().collectList()
                .map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(UserControllerRoute.ROUTE_USER_FIND_ALL_CUSTOMER)
    public Mono<ResponseEntity<?>> findAllCustomer() {
        return userService.findAllCustomer().collectList()
                .map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(UserControllerRoute.ROUTE_USER_FIND_BY_USERNAME)
    public Mono<ResponseEntity<?>> findByUsername(@PathVariable String username) {
        return usersRepo.findFirstByUsername(username)
                .map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(UserControllerRoute.ROUTE_USER_FIND_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        return usersRepo.findFirstBySku(sku)
                .map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(UserControllerRoute.ROUTE_USER_FIND_BY_STATUS_ACTIVE)
    public Mono<ResponseEntity<?>> findByStatusActive() {
        return usersRepo.findAllByStatus(StaticStatus.STATUS_ACTIVE).collectList()
                .map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(UserControllerRoute.ROUTE_USER_FIND_BY_STATUS_BLOCKED)
    public Mono<ResponseEntity<?>> findByStatusBlocked() {
        return usersRepo.findAllByStatus(StaticStatus.STATUS_BLOCKED).collectList()
                .map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @PutMapping(UserControllerRoute.ROUTE_USER_EDIT_BY_SKU)
    public Mono<ResponseEntity<?>> editBySku(@PathVariable String sku, @RequestBody UpdateUserRequest request) {
        return Mono.fromCallable(() -> request).
                doOnNext(data -> userService.editBySku(sku, request).subscribe()).flatMap(
                data -> usersRepo.findFirstBySku(sku)).map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                }
        );
    }

}
