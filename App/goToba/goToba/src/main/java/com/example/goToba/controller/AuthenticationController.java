package com.example.goToba.controller;

import com.example.goToba.controller.route.AuthenticationControllerRoute;
import com.example.goToba.payload.RegisterRequest;
import com.example.goToba.service.implement.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/03/2020.
 */
@CrossOrigin
@RestController
@RequestMapping(AuthenticationControllerRoute.ROUTE_AUTH)
public class AuthenticationController {

    @Autowired
    AuthenticationServiceImpl authenticationServiceImpl;

    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_UP)
    public ResponseEntity<?> register(@RequestBody  RegisterRequest registerRequest){
        return authenticationServiceImpl.register(registerRequest);
    }
}
