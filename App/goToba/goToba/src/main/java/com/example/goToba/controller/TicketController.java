package com.example.goToba.controller;

import com.example.goToba.controller.route.OrderDetailControllerRoute;
import com.example.goToba.controller.route.TicketControllerRoute;
import com.example.goToba.payload.ActionResponses;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.TicketRequest;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
@RestController
@RequestMapping(TicketControllerRoute.ROUTE_TICKET)
public class TicketController {
    @Autowired
    TicketService ticketService;

    @Autowired
    UsersRepo usersRepo;

    @GetMapping(TicketControllerRoute.ROUTE_TICKET_ALL)
    public Mono<ResponseEntity<?>> findAll() {
        return ticketService.findALl().collectList().map(data -> {
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
        });
    }

    @GetMapping(TicketControllerRoute.ROUTE_TICKET_ALL_BY_MERCHANT_SKU)
    public Mono<ResponseEntity<?>> findAllByMerchantSku(@PathVariable String merchantSku) {
        return ticketService.findAllByMerchantSku(merchantSku).collectList().map(data -> {
            if (data.size() != 0) {
                return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
            }
            return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_ALL_BY_MERCHANT_SKU));
        }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_ALL_BY_MERCHANT_SKU)));
    }

    @GetMapping(TicketControllerRoute.ROUTE_TICKET_ALL_BY_CATEGORY)
    public Mono<ResponseEntity<?>> findAllByCategory(@PathVariable String category) {
        return ticketService.findAllByCategory(category)
                .collectList()
                .map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(TicketControllerRoute.ROUTE_TICKET_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        return ticketService.findBySku(sku)
                .map(data -> {
                    if (data.getSku() != null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "ticket with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "ticket with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_BY_SKU)));

    }

    @PostMapping(TicketControllerRoute.ROUTE_TICKET_ADD_BY_MERCHANT_SKU)
    public Mono<ResponseEntity<?>> addBySkuMerchant(@PathVariable String merchantSku, @RequestBody TicketRequest ticketRequest) {
        return usersRepo.findFirstBySku(merchantSku)
                .map(data -> {
                    if (data.getUsername() != null) {
                        ticketService.addByMerchantSku(merchantSku, ticketRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS_CREATED, StaticResponseStatus.RESPONSE_STATUS_CREATED, ticketRequest));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_ADD_BY_MERCHANT_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "merchant with sku " + merchantSku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_ADD_BY_MERCHANT_SKU)));
    }


    @PutMapping(TicketControllerRoute.ROUTE_TICKET_EDIT_BY_SKU)
    public Mono<ResponseEntity<?>> editBySku(@PathVariable String sku, @RequestBody TicketRequest ticketRequest) {
        return Mono.fromCallable(() -> ticketRequest)
                .flatMap(data -> ticketService.findBySku(sku))
                .map(data -> {
                    System.out.println(data.getId());
                    if (data.getId() != null) {
                        ticketService.editBySku(sku, ticketRequest).subscribe();
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "ticket with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_EDIT_BY_SKU));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "ticket with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_EDIT_BY_SKU)));
    }

    @DeleteMapping(TicketControllerRoute.ROUTE_TICKET_DELETE_BY_SKU)
    public Mono<ResponseEntity<?>> deleteBySku(@PathVariable String sku) {
        return ticketService.findBySku(sku).map(data -> {
            if (data.getId() != null) {
                ticketService.deleteBySku(sku).subscribe();
                return ResponseEntity.ok().body(new ActionResponses(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_SUCCESS_DELETE_TICKET + sku));
            }
            return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "ticket with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_EDIT_BY_SKU));
        }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "ticket with sku " + sku, OrderDetailControllerRoute.ROUTE_ORDER + TicketControllerRoute.ROUTE_TICKET_EDIT_BY_SKU)));
    }
}
