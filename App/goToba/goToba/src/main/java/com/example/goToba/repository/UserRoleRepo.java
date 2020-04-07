package com.example.goToba.repository;

import com.example.goToba.model.UserRole;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/03/2020.
 */
@Repository
public interface UserRoleRepo extends ReactiveMongoRepository<UserRole,String> {
}
