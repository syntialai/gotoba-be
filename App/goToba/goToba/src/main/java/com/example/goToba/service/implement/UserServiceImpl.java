package com.example.goToba.service.implement;

import com.example.goToba.model.RoleName;
import com.example.goToba.model.SequenceUsers;
import com.example.goToba.model.Users;
import com.example.goToba.payload.AuthenticationResponse;
import com.example.goToba.payload.JwtLoginResponse;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.security.Encode;
import com.example.goToba.security.JwtTokenProvider;
import com.example.goToba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SequenceUsersRepo sequenceUsersRepo;

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private Encode passwordEncoder;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Override
    public Mono<Users> findFirstBySku(String sku) {
        return usersRepo.findFirstBySku(sku);
    }

    @Override
    public String skuGenerator(String key, Integer seq) {
        String counter = "_000";
        return key + counter + seq;
    }

    @Override
    public String sub_str(String str) {
        return str.substring(0, 4).toUpperCase();
    }

    @Override
    public Mono<Users> save(RegisterRequest request) {
        String key = sub_str(request.getNickname());
        return Mono.fromCallable(() -> request)
                .flatMap(i -> sequenceUsersRepo.findFirstByKey(key))
                .doOnNext(i -> sequenceUsersRepo.deleteByKey(key).subscribe())
                .doOnNext(i -> sequenceUsersRepo.save(new SequenceUsers(key, "000" + (Integer.parseInt(i.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceUsersRepo.save(new SequenceUsers(key, "0001")))
                .flatMap(i -> sequenceUsersRepo.findFirstByKey(key))
                .flatMap(req -> {
                    Users users = new Users(
                            skuGenerator(req.getKey(), Integer.parseInt(req.getLast_seq())),
                            request.getNickname(),
                            request.getUsername(),
                            request.getEmail(),
                            passwordEncoder.encode(request.getPassword()),
                            checkRole(request.getRole().toString()),
                            "active"
                    );
                    return usersRepo.save(users);
                });
    }


    @Override
    public Mono<ResponseEntity<?>> signin( LoginRequest request) {
        return usersRepo.findFirstByUsername(request.getUsername()).map((userDetails) -> {
            if (passwordEncoder.encode(request.getPassword()).equals(userDetails.getPassword())) {
//                Cookie cookie = new Cookie("username", "Jovan");
//                //add cookie to response
//                cookie.setSecure(true);
////                cookie.setHttpOnly(true);
//                cookie.setMaxAge( 30 * 60);
//                response.addCookie(cookie);
                return ResponseEntity.ok(new JwtLoginResponse(userDetails.getNickname(), userDetails.getRoles().toString(), userDetails.getSku(), jwtTokenProvider.generateToken(userDetails)));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthenticationResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_BAD_UNAUTHORIZED, StaticResponseStatus.RESPONSE_STATUS_ERROR_UNAUTHORIZED, StaticResponseMessages.RESPONSE_MESSAGE_USER_UNAUTHORIZED));
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @Override
    public RoleName checkRole(String role) {
        if (role.equals("ROLE_MERCHANT")) {
            return RoleName.ROLE_MERCHANT;
        } else if (role.equals("ROLE_ADMIN")) {
            return RoleName.ROLE_ADMIN;
        }
        return RoleName.ROLE_USER;
    }

    @Override
    public Mono<Users> editBySku(String sku, RegisterRequest request) {
        return Mono.fromCallable(() -> request)
                .flatMap(data -> usersRepo.findFirstBySku(sku))
                .doOnNext(id -> usersRepo.deleteBySku(sku).subscribe())
                .doOnNext(req -> {
                    Users users = new Users(
                            sku,
                            request.getNickname(),
                            request.getUsername(),
                            request.getEmail(),
                            passwordEncoder.encode(request.getPassword()),
                            req.getRoles(),
                            "active"
                    );
                    usersRepo.save(users).subscribe();
                })
                .flatMap(data -> {
                    return usersRepo.findFirstBySku(sku);
                });
    }

}
