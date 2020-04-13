package com.example.goToba.service;

import com.example.goToba.payload.request.RegisterRequest;
import org.springframework.http.ResponseEntity;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
public interface UserService {
    public String skuGenerator(String username, String role);
    public String sub_str(String str);
    public ResponseEntity<?> save(RegisterRequest registerRequest);
}
