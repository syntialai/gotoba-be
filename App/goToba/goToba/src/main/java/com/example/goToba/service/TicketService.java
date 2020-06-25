package com.example.goToba.service;

import com.example.goToba.model.Ticket;
import com.example.goToba.payload.request.TicketRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
public interface TicketService {
    Flux<Ticket> findAllByMerchantSku(String sku);
    Flux<Ticket> findALl(String sku);
    Flux<Ticket> findAllByCategory(String category);
    Mono<Ticket> findBySku(String sku);
    Mono<List<Ticket>> findBySkuUser(String skuUser);
    Mono<Ticket> addByMerchantSku(String merchantSku, TicketRequest ticketRequest);
    Mono<Ticket> editBySku(String sku, TicketRequest ticketRequest);
    Mono<Ticket> deleteBySku(String sku);
}
