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
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 17/07/2020.
 */
@SpringBootTest
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
    public void testFindFirstBySku(){
            Mono<Users> usersMono = usersRepo.findFirstBySku("HEND_001");
        assertThat(usersMono).isNotNull();
    }
}