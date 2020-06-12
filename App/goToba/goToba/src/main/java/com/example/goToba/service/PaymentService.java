package com.example.goToba.service;

import com.example.goToba.model.Payment;
import com.example.goToba.payload.request.PaymentRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/06/2020.
 */
public interface PaymentService {
    Flux<Payment> findAll();
    Mono<Payment> findBySku(String sku);
    Mono<Payment> addByUserSku(String sku, PaymentRequest  paymentRequest);
    Mono<Payment> findFirstBySkuUser(String sku);
    Mono<Payment> editBySku(String sku, PaymentRequest  paymentRequest);
}
