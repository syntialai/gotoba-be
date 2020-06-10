package com.example.goToba.controller;

import com.example.goToba.controller.route.PaymentControllerRoute;
import com.example.goToba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/06/2020.
 */
@RestController
@RequestMapping(PaymentControllerRoute.ROUTE_PAYMENT)
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping(PaymentControllerRoute.ROUTE_PAYMENT_BY_MERCHANT_SKU)
    public ResponseEntity<?> findByMerchantSku(@PathVariable String merchantSku){
        return ResponseEntity.ok("");
    }
}
