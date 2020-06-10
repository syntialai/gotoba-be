package com.example.goToba.repository;

import com.example.goToba.model.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/06/2020.
 */
@Repository
public interface PaymentRepo extends ReactiveMongoRepository<Payment,Integer> {
}
