package com.example.goToba.controller;

import com.example.goToba.controller.route.OrderDetailControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.OrderDetailRequest;
import com.example.goToba.service.OrderDetailService;
import com.example.goToba.service.redisService.OrderDetailRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@RestController
@RequestMapping(OrderDetailControllerRoute.ROUTE_ORDER)
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderDetailRedisService orderDetailRedisService;

    @GetMapping(OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        if (orderDetailRedisService.hasKey(sku)) {
            return orderDetailRedisService.findById(sku).map(data -> {
                return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
            });
        }
        return orderDetailService.findBySku(sku).map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });
    }

    @GetMapping(OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_MERCHANT)
    public Mono<ResponseEntity<?>> findAllBySkuMerchant(@PathVariable String merchantSku) {
        return orderDetailService.findAll().
                filter(data -> data.getMerchantSku().equals(merchantSku)).
                collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_USER)
    public Mono<ResponseEntity<?>> findALlBySkuUser(@PathVariable String userSku) {
        return orderDetailService.findAll().
                filter(data -> data.getUserSku().equals(userSku)).
                collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @PostMapping(OrderDetailControllerRoute.ROUTE_ADD_ORDER_DETAIL_BY_SKU_USER)
    public Mono<ResponseEntity<?>> addOrderDetailBySkuUser(@PathVariable String userSku, @RequestBody OrderDetailRequest orderDetailRequest){
        return orderDetailService.addBySkuUser(userSku, orderDetailRequest).
                flatMap(data -> orderDetailService.findFirstBySkuUser(userSku)).
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS,StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK,data));
                });
    }

}
