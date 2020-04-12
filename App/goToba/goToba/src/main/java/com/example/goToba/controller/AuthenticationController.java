package com.example.goToba.controller;

import com.example.goToba.controller.route.AuthenticationControllerRoute;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.service.implement.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/03/2020.
 */
@CrossOrigin
@RestController
@RequestMapping(AuthenticationControllerRoute.ROUTE_AUTH)
public class AuthenticationController {
//
//    @Autowired
//    AuthenticationServiceImpl authenticationService;
//
//    @Autowired
//    JwtTokenProvider jwtTokenProvider;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    UsersServiceImpl usersService;
//
//    @Autowired
//    TestingMultiple testingMultiple;
//     @GetMapping("/test/{username}")
//     public Users findwithUsername(@PathVariable String username){
//         return usersService.findByUsername(username);
//     }
//
//    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_UP)
//    public ResponseEntity<?> register(@RequestBody  RegisterRequest registerRequest){
//        return authenticationService.register(registerRequest);
//    }
//
//    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_IN)
//    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
//        return authenticationService.login(loginRequest);
//    }
}
