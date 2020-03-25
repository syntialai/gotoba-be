package com.example.goToba.controller;

import com.example.goToba.payload.RegisterRequest;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/03/2020.
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(RegisterRequest registerRequest){

        return authenticationService.register(registerRequest);
    }
}
