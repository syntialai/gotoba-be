package com.example.goToba.controller;

import com.example.goToba.controller.route.PaymentControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.PaymentRequest;
import com.example.goToba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public Mono<ResponseEntity<?>> findByMerchantSku(@PathVariable String merchantSku) {
        return paymentService.findAll().filter(data -> data.getMerchantSku().equals(merchantSku)).collectList().map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });
    }

    @GetMapping(PaymentControllerRoute.ROUTE_PAYMENT_BY_MERCHANT_SKU_AND_CATEGORY)
    public Mono<ResponseEntity<?>> findByMerchantSkuAndCategory(@PathVariable String merchantSku, @PathVariable String category) {
        return paymentService.findAll().filter(data -> data.getMerchantSku().equals(merchantSku)).filter(data -> data.getCategory().equals(category)).collectList().map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });
    }

    @GetMapping(PaymentControllerRoute.ROUTE_PAYMENT_BY_USER_SKU_AND_CATEGORY)
    public Mono<ResponseEntity<?>> findByUserSkuAndStatus(@PathVariable String userSku, @PathVariable String status) {
        return paymentService.findAll().filter(data -> data.getUserSku().equals(userSku)).filter(data -> data.getStatus().equals(status)).collectList().map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });
    }

    @GetMapping(PaymentControllerRoute.ROUTE_PAYMENT_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        return paymentService.findBySku(sku).map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });
    }

    @PostMapping(PaymentControllerRoute.ROUTE_ADD_PAYMENT_BY_USER_SKU)
    public Mono<ResponseEntity<?>> addPayementByUserSku(@PathVariable String userSku, @RequestBody PaymentRequest paymentRequest) {
        return Mono.fromCallable(() -> paymentService.addByUserSku(userSku, paymentRequest).subscribe()).
                flatMap(data -> paymentService.findFirstBySkuUser(userSku)).
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @PutMapping(PaymentControllerRoute.ROUTE_EDIT_PAYMENT_BY_SKU)
    public Mono<ResponseEntity> editPaymentBySku(@PathVariable String sku, @RequestBody PaymentRequest paymentRequest){
        return Mono.fromCallable(() -> paymentService.editBySku(sku, paymentRequest).subscribe()).
                flatMap(
                        data -> paymentService.findBySku(sku)
                ).
                map(
                        data -> {
                            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                        }
                );
    }

}
