package com.example.goToba.controller;


import com.example.goToba.model.Users;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    SequenceUsersRepo sequenceUsersRepo;
    List list = null;
    @GetMapping("/")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("Success");
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegisterRequest registerRequest){
        userService.save(registerRequest);
        return ResponseEntity.ok("Register Success");
    }
    @GetMapping("/x/{name}")
    public Mono<Users> findByName(@PathVariable String name){
        Mono<Users> usersMono= usersRepo.findFirstByUsername(name);
        List list=null;
        return usersMono
                .doOnNext(string -> System.out.println(string.getStatus()))
//                .flatMap(string -> toUpperCase(string))
//                .flatMap(string -> length(string))
                .doOnNext(string -> System.out.println(string));

    }
}
