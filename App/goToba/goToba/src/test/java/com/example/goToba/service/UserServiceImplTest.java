package com.example.goToba.service;

import com.example.goToba.model.RoleName;
import com.example.goToba.model.Users;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.security.Encode;
import com.example.goToba.security.JwtTokenProvider;
import com.example.goToba.service.implement.UserServiceImpl;
import com.example.goToba.service.utils.CookieUtil;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
/**
 * Created by Sogumontar Hendra Simangunsong on 17/07/2020.
 */

public class UserServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
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
        Users users = Users.builder().status("active").build();
        when(usersRepo.findFirstBySku("HEND_0001")).thenReturn(Mono.just(users));
//        assertThat(userService.findFirstBySku("HEND_0001")).isEqualTo(usersRepo.findFirstBySku("HEND_0001"));
        assertThat(users).isNotNull();
//        assertEquals(userService.findFirstBySku("HEND_0001"),Mono.just(users));
        StepVerifier.create(userService.findFirstBySku("HEND_0001"))
                .consumeNextWith(r -> {
                    assertEquals(r ,users);
                })
                .expectComplete()
                .verify();
        verify(usersRepo).findFirstBySku("HEND_0001");
    }

    @Test
    public void testFindAllCustomer() {
        Users users = Users.builder().roles(RoleName.ROLE_USER).build();
//        Flux<Users> usersFlux = Flux.just(users);
        when(usersRepo.findAll()).thenReturn(Flux.just(users).filter(data -> data.getRoles().toString().equals("ROLE_USER")));
//        StepVerifier.create(userService.findAllCustomer())
//                .expectNext(users)
//                .expectComplete()
//                .verify();
//        verify(usersRepo).findAll();
    }
}