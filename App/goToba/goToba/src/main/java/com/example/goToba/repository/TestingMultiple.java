package com.example.goToba.repository;

import com.example.goToba.model.TestTable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/03/2020.
 */
@Repository
public interface TestingMultiple extends ReactiveMongoRepository<TestTable,String> {

}
