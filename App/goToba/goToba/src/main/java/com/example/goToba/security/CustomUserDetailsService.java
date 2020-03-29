package com.example.goToba.security;

import com.example.goToba.model.Users;
import com.example.goToba.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username
        Users user = usersRepo.findByUsernameOrEmail(username,username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + username)
                );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(String sku) {
        Users user = usersRepo.findFirstBySku(sku);

        return UserPrincipal.create(user);
    }
}
