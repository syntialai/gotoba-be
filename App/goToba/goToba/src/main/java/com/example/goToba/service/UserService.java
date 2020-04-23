package com.example.goToba.service;

import com.example.goToba.model.Users;
import com.example.goToba.payload.request.RegisterRequest;
import org.springframework.http.ResponseEntity;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
public interface UserService {
    public String skuGenerator(String username, String role);
    public String sub_str(String str);
    public Mono<Users> save(RegisterRequest registerRequest);
    public Mono<Users> findByNickname(String nickname);
    public Disposable sequenceSku(String key, Users users);
}
