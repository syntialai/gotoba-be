package com.example.goToba.service;

import com.example.goToba.model.OrderDetail;
import com.example.goToba.payload.request.OrderDetailRequest;
import com.example.goToba.payload.request.OrderDetailTicket;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
public interface OrderDetailService {
    Mono<OrderDetail> findBySku(String sku);
    Mono<OrderDetail> findFirstBySku(String sku);
    Mono<OrderDetail> findFirstBySkuUser(String skuUser);
    Flux<OrderDetail> findAll();
    Boolean checkTicket(List<OrderDetailTicket> orderDetailTickets, String merchantSku);
    Mono<OrderDetail> addBySkuUser(String skuUser, OrderDetailRequest orderDetailRequest);
    Mono<OrderDetail> editBySku(String sku, OrderDetailRequest orderDetailRequest);
}
