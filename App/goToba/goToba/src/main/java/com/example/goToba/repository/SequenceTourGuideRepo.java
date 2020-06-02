package com.example.goToba.repository;

import com.example.goToba.model.SequenceTourGuide;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
@Repository
public interface SequenceTourGuideRepo extends ReactiveMongoRepository<SequenceTourGuide,String> {
    public Mono<SequenceTourGuide> findFirstByKey(String key);
    Mono<Boolean> deleteByKey(String key);
}
