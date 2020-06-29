package com.example.goToba.repository;

import com.example.goToba.model.SequenceTicket;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/06/2020.
 */
@Repository
public interface SequenceTicketRepo extends ReactiveMongoRepository<SequenceTicket,String> {
    public Mono<SequenceTicket> findFirstByKey(String key);
    Mono<Boolean> deleteByKey(String key);
}
