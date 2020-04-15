package com.example.goToba.controller;


import com.example.goToba.controller.route.UserControllerRoute;
import com.example.goToba.model.Users;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@RestController
@RequestMapping(UserControllerRoute.ROUTE_AUTH)
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    SequenceUsersRepo sequenceUsersRepo;

    @GetMapping(UserControllerRoute.ROUTE_USER_FIND_ALL)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(usersRepo.findAll());
    }

    @PostMapping(UserControllerRoute.ROUTE_SIGN_UP)
    public ResponseEntity<?> signup(@RequestBody RegisterRequest registerRequest) {
        userService.save(registerRequest);
        return ResponseEntity.ok("Register Success");
    }

    @GetMapping(UserControllerRoute.ROUTE_USER_FIND_BY_NICKNAME)
    public ResponseEntity<?> findByNickName(@PathVariable String nickname) {
        return ResponseEntity.ok(userService.findByNickname(nickname));
    }
}
