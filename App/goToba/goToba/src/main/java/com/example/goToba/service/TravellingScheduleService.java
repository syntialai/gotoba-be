package com.example.goToba.service;

import com.example.goToba.model.TravellingSchedule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
public interface TravellingScheduleService {
    Flux<TravellingSchedule> findAll();
    Mono<TravellingSchedule> findByScheduleId(String id);
    Mono<TravellingSchedule> updateById(String id);
}
