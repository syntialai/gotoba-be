package com.example.goToba.repository;

import com.example.goToba.model.TravellingSchedule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Repository
public interface TravellingScheduleRepo extends ReactiveMongoRepository<TravellingSchedule,Integer> {

}
