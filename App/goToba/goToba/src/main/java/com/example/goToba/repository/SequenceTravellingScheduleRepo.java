package com.example.goToba.repository;

import com.example.goToba.model.SequenceTravellingSchedule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 27/07/2020.
 */
@Repository
public interface SequenceTravellingScheduleRepo extends ReactiveMongoRepository<SequenceTravellingSchedule,String> {
    public Mono<SequenceTravellingSchedule> findFirstByKey(String key);
    Mono<Boolean> deleteByKey(String key);
}
