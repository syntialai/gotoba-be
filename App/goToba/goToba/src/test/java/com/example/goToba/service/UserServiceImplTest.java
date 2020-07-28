package com.example.goToba.service;

import com.example.goToba.model.Users;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.security.Encode;
import com.example.goToba.security.JwtTokenProvider;
import com.example.goToba.service.implement.UserServiceImpl;
import com.example.goToba.service.utils.CookieUtil;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Created by Sogumontar Hendra Simangunsong on 17/07/2020.
 */

public class UserServiceImplTest {
    @Mock
    SequenceUsersRepo sequenceUsersRepo;
    @Mock
    UsersRepo usersRepo;
    @Mock
    private JwtTokenProvider jwtTokenProvider;
    @Mock
    private Encode passwordEncoder;
    @Mock
    CookieUtil cookieUtil;
    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void testFindFirstBySku() {
        Users users =  Users.builder().status("active").build();
        when(usersRepo.findFirstBySku("HEND_0001")).thenReturn(Mono.just(new Users()));
//        assertThat(usersMono).isNotNull();
    }

    @Test
    public void testFindAllCustomer(){
//        when(usersRepo.)
    }
}