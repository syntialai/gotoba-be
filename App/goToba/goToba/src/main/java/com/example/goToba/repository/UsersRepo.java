package com.example.goToba.repository;

import com.example.goToba.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/03/2020.
 */
@Repository
public interface UsersRepo  extends JpaRepository<Users,String> {
    Optional<Users> findByUsernameOrEmail(String email,String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Users findByUsername(String username);
    Users findFirstBySku(String sku);
}
