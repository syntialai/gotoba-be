package com.example.goToba.service;

import com.example.goToba.exception.AppException;
import com.example.goToba.model.RoleName;
import com.example.goToba.model.Roles;
import com.example.goToba.model.Users;
import com.example.goToba.payload.RegisterRequest;
import com.example.goToba.repository.RoleRepo;
import com.example.goToba.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/03/2020.
 */
@Service
public class AuthenticationService {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    RoleRepo roleRepo;
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        Users users=new Users(
                "sku",
                registerRequest.getNickname(),
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                1
                );
        Roles roles =checkRole(registerRequest.getRole().toString());
        users.setRoles(Collections.singleton(roles));


        return ResponseEntity.ok(usersRepo.save(users));
    }

    public Roles checkRole(String role){
        Roles roles=new Roles();
        if(role.equals(RoleName.ROLE_ADMIN)){
            roles = roleRepo.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new AppException("User Role not set."));
        }else if(role.equals(RoleName.ROLE_MERCHANT)){
            roles = roleRepo.findByName(RoleName.ROLE_MERCHANT)
                    .orElseThrow(() -> new AppException("User Role not set."));
        }else if( role.equals(RoleName.ROLE_USER)){
            roles = roleRepo.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new AppException("User Role not set."));
        }
        return roles;
    }
}
