package com.example.goToba.service;

import com.example.goToba.model.Users;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */
public interface UsersService {
    public Users findByUsername(String username);
}
