package com.example.goToba.repository;

import com.example.goToba.model.SequenceUsers;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */

@Repository
public interface SequenceUsersRepo extends ReactiveMongoRepository<SequenceUsers,Integer> {
    public Mono<SequenceUsers> findFirstByKey(String key);
}
