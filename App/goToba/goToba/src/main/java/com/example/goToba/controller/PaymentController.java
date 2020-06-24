package com.example.goToba.controller;

import com.example.goToba.controller.route.PaymentControllerRoute;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.PaymentUpdateRequest;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.PaymentRequest;
import com.example.goToba.service.PaymentService;
import com.example.goToba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/06/2020.
 */
@RestController
@RequestMapping(PaymentControllerRoute.ROUTE_PAYMENT)
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    UserService userService;

    @GetMapping(PaymentControllerRoute.ROUTE_PAYMENT_BY_MERCHANT_SKU)
    public Mono<ResponseEntity<?>> findByMerchantSku(@PathVariable String merchantSku) {
        return paymentService.findAll()
                .filter(data -> data.getMerchantSku().equals(merchantSku))
                .collectList()
                .map(data -> {
                    if (data.size()!=0) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_PAYMENT_BY_MERCHANT_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_PAYMENT_BY_MERCHANT_SKU)));
    }

//    @GetMapping(PaymentControllerRoute.ROUTE_PAYMENT_BY_MERCHANT_SKU_AND_CATEGORY)
//    public Mono<ResponseEntity<?>> findByMerchantSkuAndCategory(@PathVariable String merchantSku, @PathVariable String category) {
//        return paymentService.findAll()
//                .filter(data -> data.getMerchantSku().equals(merchantSku))
//                .filter(data -> data.getCategory().equals(category))
//                .collectList()
//                .map(data -> {
//                    if (data.size() != 0) {
//                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
//                    }
//                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "payment with category " + category, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_PAYMENT_BY_MERCHANT_SKU_AND_CATEGORY));
//                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "payment with category " + category, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_PAYMENT_BY_MERCHANT_SKU_AND_CATEGORY)));
//    }

    @GetMapping(PaymentControllerRoute.ROUTE_PAYMENT_BY_USER_SKU_AND_STATUS)
    public Mono<ResponseEntity<?>> findByUserSkuAndStatus(@PathVariable String userSku, @PathVariable String status) {
        return paymentService.findAll()
                .filter(data -> data.getUserSku().equals(userSku))
                .filter(data -> data.getStatus().equals(status))
                .collectList()
                .map(data -> {
                    if (data.size() != 0) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with sku " + userSku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_PAYMENT_BY_USER_SKU_AND_STATUS));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with sku " + userSku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_PAYMENT_BY_USER_SKU_AND_STATUS)));
    }

    @GetMapping(PaymentControllerRoute.ROUTE_PAYMENT_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        return paymentService.findBySku(sku)
                .map(data -> {
                    if (data.getUserSku() != null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "payment with sku " + sku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_PAYMENT_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "payment with sku " + sku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_PAYMENT_BY_SKU)));
    }

    @PostMapping(PaymentControllerRoute.ROUTE_ADD_PAYMENT_BY_USER_SKU)
    public Mono<ResponseEntity<?>> addPayementByUserSku(@PathVariable String userSku, @RequestBody PaymentRequest paymentRequest) {
        return userService.findFirstBySku(userSku)
                .map(data -> {
                    if (data.getUsername() != null) {
                        paymentService.addByUserSku(userSku, paymentRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with sku " + userSku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_EDIT_PAYMENT_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "user with sku " + userSku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_EDIT_PAYMENT_BY_SKU)));
    }

    @PutMapping(PaymentControllerRoute.ROUTE_EDIT_PAYMENT_BY_SKU)
    public Mono<ResponseEntity<?>> editPaymentBySku(@PathVariable String sku, @RequestBody PaymentUpdateRequest paymentUpdateRequest) {
        return paymentService.findBySku(sku).
                map(data -> {
                    if (data.getUserSku() != null) {
                        paymentService.editBySku(sku, paymentUpdateRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "payment with sku " + sku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_ADD_PAYMENT_BY_USER_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "payment with sku " + sku, PaymentControllerRoute.ROUTE_PAYMENT + PaymentControllerRoute.ROUTE_ADD_PAYMENT_BY_USER_SKU)));
    }

}
