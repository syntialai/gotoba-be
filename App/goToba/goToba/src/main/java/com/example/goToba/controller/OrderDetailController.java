package com.example.goToba.controller;

import com.example.goToba.controller.route.OrderDetailControllerRoute;
import com.example.goToba.model.Ticket;
import com.example.goToba.payload.DeleteResponse;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.OrderDetailRequest;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.OrderDetailService;
import com.example.goToba.service.redisService.OrderDetailRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@RestController
@RequestMapping(OrderDetailControllerRoute.ROUTE_ORDER)
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    OrderDetailRedisService orderDetailRedisService;

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    TicketRepo ticketRepo;

    @GetMapping("/all/")
    public Mono<ResponseEntity<?>> findAll() {
        return orderDetailRepo.findAll().collectList().map(data -> {
            return ResponseEntity.ok(data);
        });
    }

    @GetMapping(OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        if (orderDetailRedisService.hasKey(sku)) {
            return orderDetailRedisService.findById(sku).map(data -> {
                return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
            });
        }
        return orderDetailService.findBySku(sku);
    }

    @GetMapping(OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_MERCHANT)
    public Mono<ResponseEntity<?>> findAllBySkuMerchant(@PathVariable String merchantSku) {
        return orderDetailService.findAll().filter(data -> orderDetailService.checkTicket(data.getTicket(),merchantSku)==true)
                .collectList().map(data -> {
                    if (data.size() != 0) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with merchant sku " + merchantSku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_MERCHANT));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with merchant sku " + merchantSku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_MERCHANT)));
    }


    @GetMapping(OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_USER)
    public Mono<ResponseEntity<?>> findALlBySkuUser(@PathVariable String userSku) {
        return orderDetailService.findAll()
                .filter(data -> data.getUserSku().equals(userSku))
                .collectList()
                .map(data -> {
                    if (data.size() != 0) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with sku " + userSku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_USER));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with sku " + userSku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_USER)));
    }

    @PostMapping(OrderDetailControllerRoute.ROUTE_ADD_ORDER_DETAIL_BY_SKU_USER)
    public Mono<ResponseEntity<?>> addOrderDetailBySkuUser(@PathVariable String userSku, @RequestBody OrderDetailRequest orderDetailRequest) {
        return usersRepo.findFirstBySku(userSku)
                .map(data -> {
                    if (data.getUsername() != null) {
                        orderDetailService.addBySkuUser(userSku, orderDetailRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with sku " + userSku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_USER));
                })
                .defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with sku " + userSku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_USER)));
    }

    @PutMapping(OrderDetailControllerRoute.ROUTE_EDIT_ORDER_DETAIL_BY_SKU)
    public Mono<ResponseEntity<?>> editOrderDetailBySku(@PathVariable String sku, @RequestBody OrderDetailRequest orderDetailRequest) {
        return orderDetailRepo.findFirstBySku(sku)
                .map(result -> {
                    if (result.getUserSku() != null) {
                        orderDetailService.editBySku(sku, orderDetailRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, result));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "order with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_USER));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "order with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU_USER)));
    }

    @DeleteMapping(OrderDetailControllerRoute.ROUTE_DELETE_ORDER_DETAIL_BY_SKU)
    public Mono<ResponseEntity<?>> deleteBySku(@PathVariable String sku) {
        return orderDetailService.findFirstBySku(sku)
                .map(data -> {
                    if (data.getUserSku() != null) {
                        orderDetailService.deleteBySku(sku).subscribe();
                        return ResponseEntity.ok().body(new DeleteResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_DELETE_WISATA));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "order with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_DELETE_ORDER_DETAIL_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "order with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_DELETE_ORDER_DETAIL_BY_SKU)));
    }
}
