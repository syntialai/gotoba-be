package com.example.goToba.service;

import com.example.goToba.model.OrderDetail;
import com.example.goToba.payload.request.OrderDetailRequest;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
public interface OrderDetailService {
    Mono<ResponseEntity<?>> findBySku(String sku);
    Mono<OrderDetail> findFirstBySku(String sku);
    Mono<OrderDetail> findFirstBySkuUser(String skuUser);
    Flux<OrderDetail> findAll();
    Mono<OrderDetail> addBySkuUser(String skuUser, OrderDetailRequest orderDetailRequest);
    Mono<OrderDetail> editBySku(String sku, OrderDetailRequest orderDetailRequest);
    Mono<OrderDetail> deleteBySku(String sku);
}
