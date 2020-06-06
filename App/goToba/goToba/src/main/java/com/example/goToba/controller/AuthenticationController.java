package com.example.goToba.controller;


import com.example.goToba.controller.route.AuthenticationControllerRoute;
import com.example.goToba.controller.route.UserControllerRoute;
import com.example.goToba.payload.AuthenticationResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@RestController
@RequestMapping(AuthenticationControllerRoute.ROUTE_AUTH)
public class AuthenticationController {
    @Autowired
    UserServiceImpl userService;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_UP)
    public ResponseEntity<?> signup(@RequestBody RegisterRequest registerRequest) {
        userService.save(registerRequest).subscribe();
        return ResponseEntity.ok().body(new AuthenticationResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGE_USER_REGISTERED));
    }

    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_IN)
    public Mono<ResponseEntity<?>> signin(@RequestBody LoginRequest request) {
        return userService.signin(request);
    }

}
