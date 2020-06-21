package com.example.goToba.service.implement;

import com.example.goToba.controller.route.OrderDetailControllerRoute;
import com.example.goToba.model.OrderDetail;
import com.example.goToba.model.Restaurant;
import com.example.goToba.payload.AuthenticationResponse;
import com.example.goToba.payload.JwtLoginResponse;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.OrderDetailRequest;
import com.example.goToba.payload.request.OrderDetailTicket;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.service.OrderDetailService;
import com.example.goToba.service.redisService.OrderDetailRedisService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    OrderDetailRedisService orderDetailRedisService;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Override
    public Mono<ResponseEntity<?>> findBySku(String sku) {
        return orderDetailRepo.findFirstBySku(sku).map((data) -> {
            if(orderDetailRepo.existsBySku(sku)){
                orderDetailRedisService.add(data);
                return ResponseEntity.status(HttpStatus.OK).body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(new NotFoundResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_UNAUTHORIZED, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND+"order with sku "+sku+".", OrderDetailControllerRoute.ROUTE_ORDER+OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU));
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.OK).body(new NotFoundResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND+"order with sku "+sku+".", OrderDetailControllerRoute.ROUTE_ORDER+OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU)));
    }

    @Override
    public Mono<OrderDetail> findFirstBySkuUser(String skuUser) {
        return orderDetailRepo.findFirstByUserSku(skuUser);
    }

    @Override
    public Flux<OrderDetail> findAll() {
        return orderDetailRepo.findAll();
    }

    @Override
    public Mono<OrderDetail> addBySkuUser(String skuUser, OrderDetailRequest orderDetailRequest) {
        OrderDetail orderDetail =  new OrderDetail(
                UUID.randomUUID().toString(),
                orderDetailRequest.getTicket(),
                skuUser
        );
        return orderDetailRepo.save(orderDetail);
    }

    @Override
    public Mono<OrderDetail> editBySkuUser(String sku, OrderDetailRequest orderDetailRequest) {
        return Mono.fromCallable(() -> orderDetailRequest)
                .flatMap(data -> orderDetailRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    orderDetailRepo.deleteBySku(sku).subscribe();
                    orderDetailRedisService.delete(sku);
                })
                .flatMap(data -> {
                    OrderDetail orderDetail =new OrderDetail(
                            sku,
                            orderDetailRequest.getTicket(),
                            data.getUserSku()
                    );
                    orderDetailRedisService.add(orderDetail);
                    return orderDetailRepo.save(orderDetail);
                });

    }

    @Override
    public Mono<Boolean> deleteBySku(String sku){
        return  orderDetailRepo.deleteBySku(sku);
    }
}
