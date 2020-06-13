package com.example.goToba.repository;

import com.example.goToba.model.Ticket;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
@Repository
public interface TicketRepo extends ReactiveMongoRepository<Ticket,Integer> {
    Mono<Ticket> findFirstBySku(String sku);
}
