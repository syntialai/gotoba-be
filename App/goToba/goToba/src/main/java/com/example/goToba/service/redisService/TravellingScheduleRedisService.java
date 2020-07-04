package com.example.goToba.service.redisService;

import com.example.goToba.model.TravellingSchedule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 03/07/2020.
 */
public interface TravellingScheduleRedisService<T> {
    void add(TravellingSchedule travellingSchedule);
    Mono<T> findById(Integer id);
    List<?> findAll();
    Boolean hasKey(Integer id);
    void deleteByKey(Integer id);
}
