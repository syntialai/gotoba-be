package com.example.goToba.service;

import com.example.goToba.model.Ticket;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
public interface TicketService {
    Flux<Ticket> findAllByMerchantSku(String sku);
    Flux<Ticket> findALl(String sku);
    Flux<Ticket> findAllByCategory(String category);
    Mono<Ticket> findBySku(String sku);
    Flux<Ticket> findBySkuUser(String skuUser);
}
