package com.example.goToba.controller;

import com.example.goToba.controller.route.AdminControllerRoute;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 21/06/2020.
 */
@RestController
@RequestMapping(AdminControllerRoute.ROUTE_FOR_ADMIN)
public class AdminController {
    @Autowired
    UsersRepo usersRepo;

    @GetMapping(AdminControllerRoute.ROUTE_FOR_ADMIN_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku){
        return usersRepo.findFirstBySku(sku).map(admin -> {
            if(admin.getUsername()!=null) {
                return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, admin));
            }
            return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, AdminControllerRoute.ROUTE_FOR_ADMIN + AdminControllerRoute.ROUTE_FOR_ADMIN_BY_SKU));
        }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, AdminControllerRoute.ROUTE_FOR_ADMIN + AdminControllerRoute.ROUTE_FOR_ADMIN_BY_SKU))););
    }

    @GetMapping
}
