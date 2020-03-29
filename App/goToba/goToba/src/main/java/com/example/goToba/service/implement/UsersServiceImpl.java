package com.example.goToba.service.implement;

import com.example.goToba.model.Users;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public Users findByUsername(String username) {
        return usersRepo.findByUsername(username);
    }
}
