package com.example.goToba.service;

import com.example.goToba.model.Roles;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/03/2020.
 */
public interface AuthenticationService {
    ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest);
    ResponseEntity<?> login(@RequestBody LoginRequest loginRequest);
    String checkRole(String role);
    String skuGenerator(String Username,String role);
    ResponseEntity<?> checkUsername(String username);
    ResponseEntity<?> checkEmail(String email);
    String sub_str(String str);
    Boolean checkPassword(String password, String confirmPassword);
}