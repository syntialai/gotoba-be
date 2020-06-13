package com.example.goToba.controller;

import com.example.goToba.controller.route.TicketControllerRoute;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
@RestController
@RequestMapping(TicketControllerRoute.ROUTE_TICKET)
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping(TicketControllerRoute.ROUTE_TICKET_ALL_BY_MERCHANT_SKU)
    public ResponseEntity<?> findAllByMerchantSku(@PathVariable String merchantSku) {
        return ticketService.findAllByMerchantSku(merchantSku).
                collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }
}
