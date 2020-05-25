package com.example.goToba.repository;

import com.example.goToba.model.MenuRestaurants;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@Repository
public interface MenuRestaurantsRepo extends ReactiveMongoRepository<MenuRestaurants,Integer> {
}
