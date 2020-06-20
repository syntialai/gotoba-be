package com.example.goToba.repository;

import com.example.goToba.model.Reviews;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
@Repository
public interface ReviewsRepo extends ReactiveMongoRepository<Reviews,Integer> {
}
