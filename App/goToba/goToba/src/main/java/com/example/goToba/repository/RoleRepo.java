package com.example.goToba.repository;

import com.example.goToba.model.RoleName;
import com.example.goToba.model.Roles;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/03/2020.
 */
@Repository
public interface RoleRepo extends ReactiveMongoRepository<Roles, Integer> {
    Boolean existsByName(RoleName roleName);
    Optional<Roles> findByName(RoleName roleName);
}
