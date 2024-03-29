package com.example.goToba.repository;

import com.example.goToba.model.Users;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@Repository
public interface UsersRepo extends ReactiveMongoRepository<Users,String> {
    Flux<Users> findAllByStatus(String status);
    Mono<Users> findFirstByUsername(String username);
    Mono<Users> findFirstBySku(String sku);
    Mono<Void> deleteBySku(String sku);
    Boolean existsBySku(String sku);
    Boolean existsByUsername(String username);
}
