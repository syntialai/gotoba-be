package com.example.goToba.service;

import com.example.goToba.model.RoleName;
import com.example.goToba.model.Users;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.payload.request.UpdateUserRequest;
import org.springframework.http.ResponseEntity;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
public interface UserService {
    public Mono<Users> findFirstBySku(String sku);

    public String skuGenerator(String key, Integer seq);

    public String sub_str(String str);

    public Mono<Users> save(RegisterRequest registerRequest);

    public Mono<ResponseEntity<?>> signin(LoginRequest request);

    public ResponseEntity<?> signOut();

    public RoleName checkRole(String role);

    public Mono<Users> editBySku(String sku, UpdateUserRequest request);

    public Flux<Users> findAllCustomer();

    public Mono<Users> blockBySku(String sku);

    public Mono<Users> activateBySku(String sku);

}
