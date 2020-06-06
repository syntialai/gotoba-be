package com.example.goToba.service;

import com.example.goToba.model.TravellingSchedule;
import com.example.goToba.payload.request.ScheduleRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
public interface TravellingScheduleService {
    Flux<TravellingSchedule> findAll();
    Mono<TravellingSchedule> findByScheduleId(Integer id);
    Mono<TravellingSchedule> updateById(String id);
    Mono<TravellingSchedule> addBySku(String sku, ScheduleRequest scheduleRequest);
    Mono<TravellingSchedule> editById(Integer sku, ScheduleRequest scheduleRequest);
    Mono<Void> deleteById(Integer sku);
}
