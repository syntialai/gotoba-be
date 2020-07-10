package com.example.goToba.controller;

import com.example.goToba.controller.route.MerchantControllerRoute;
import com.example.goToba.model.RoleName;
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
@RequestMapping(MerchantControllerRoute.ROUTE_FOR_MERCHANT)
public class MerchantController {
    @Autowired
    UsersRepo usersRepo;

    @GetMapping(MerchantControllerRoute.ROUTE_FOR_MERCHANT_ALL)
    public Mono<ResponseEntity<?>> findAll() {
        return usersRepo.findAll().filter(data -> data.getRoles().equals(RoleName.ROLE_MERCHANT)).collectList().map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });
    }

    @GetMapping(MerchantControllerRoute.ROUTE_FOR_MERCHANT_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        return usersRepo.findFirstBySku(sku).map(data -> {
            if (data.getUsername() != null && data.getRoles().equals(RoleName.ROLE_MERCHANT)) {
                return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
            }
            return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, MerchantControllerRoute.ROUTE_FOR_MERCHANT + MerchantControllerRoute.ROUTE_FOR_MERCHANT_BY_SKU));
        }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "review with sku " + sku, MerchantControllerRoute.ROUTE_FOR_MERCHANT + MerchantControllerRoute.ROUTE_FOR_MERCHANT_BY_SKU)));
    }
}
