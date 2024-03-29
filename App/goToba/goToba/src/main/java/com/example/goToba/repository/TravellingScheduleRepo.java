package com.example.goToba.repository;

import com.example.goToba.model.TravellingSchedule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Repository
public interface TravellingScheduleRepo extends ReactiveMongoRepository<TravellingSchedule,Integer> {
    Flux<TravellingSchedule> findAll();

    Mono<TravellingSchedule> findById(String id);

    Mono<TravellingSchedule> findBySku(String sku);

    Mono<Void> deleteById(Integer id);

    Mono<Void> deleteBySku(String sku);

}
