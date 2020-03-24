package com.example.goToba.repository;

import com.example.goToba.model.RoleName;
import com.example.goToba.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/03/2020.
 */
@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {
    Boolean existsByName(RoleName roleName);
}
