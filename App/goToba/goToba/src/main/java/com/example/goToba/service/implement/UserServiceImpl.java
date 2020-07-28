package com.example.goToba.service.implement;

import com.example.goToba.model.RoleName;
import com.example.goToba.model.SequenceUsers;
import com.example.goToba.model.Users;
import com.example.goToba.payload.AuthenticationResponse;
import com.example.goToba.payload.JwtLoginResponse;
import com.example.goToba.payload.helper.*;
import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.payload.request.UpdateUserRequest;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.security.Encode;
import com.example.goToba.security.JwtTokenProvider;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.UserService;
import com.example.goToba.service.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.sql.Timestamp;

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

    @Autowired
    ImageService imageService;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Autowired
    CookieUtil cookieUtil;

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
                            ImagePath.IMAGE_PATH_USER + ImagePath.IMAGE_CONNECTOR + req.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(req.getLast_seq()) + ImagePath.IMAGE_EXTENSION,
                            StaticStatus.STATUS_ACTIVE
                    );
                    if (request.getImage() != "") {
                        try {
                            imageService.addPicture(request.getImage(), users.getSku(), ImagePath.IMAGE_PATH_USER);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return usersRepo.save(users);
                });
    }


    @Override
    public Mono<ResponseEntity<?>> signin(LoginRequest request) {
        return usersRepo.findFirstByUsername(request.getUsername()).map((userDetails) -> {
            if (passwordEncoder.encode(request.getPassword()).equals(userDetails.getPassword()) && userDetails.getStatus().equals(StaticStatus.STATUS_ACTIVE)) {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.add(HttpHeaders.SET_COOKIE, cookieUtil.createAccessTokenCookie(jwtTokenProvider.generateToken(userDetails), (long) 3600).toString());
                return ResponseEntity.ok().headers(responseHeaders).body(new JwtLoginResponse(userDetails.getNickname(), userDetails.getRoles().toString(), userDetails.getSku(), jwtTokenProvider.generateToken(userDetails)));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthenticationResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_BAD_UNAUTHORIZED, StaticResponseStatus.RESPONSE_STATUS_ERROR_UNAUTHORIZED, StaticResponseMessages.RESPONSE_MESSAGE_USER_UNAUTHORIZED));
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthenticationResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_BAD_UNAUTHORIZED, StaticResponseStatus.RESPONSE_STATUS_ERROR_UNAUTHORIZED, StaticResponseMessages.RESPONSE_MESSAGE_USER_UNAUTHORIZED)));
    }

    @Override
    public ResponseEntity<?> signOut() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(HttpHeaders.SET_COOKIE, cookieUtil.deleteAccessTokenCookie().toString());
        return ResponseEntity.ok().headers(responseHeaders).body("test");

//        return ResponseCookie.from("accesToken","").maxAge(0).httpOnly(true).path("/").build();
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
    public Mono<Users> editBySku(String sku, UpdateUserRequest request) {
        return usersRepo.findFirstBySku(sku)
                .flatMap(req -> {
                    usersRepo.deleteBySku(sku);
                    Users users = new Users(
                            sku,
                            request.getNickname(),
                            request.getUsername(),
                            request.getEmail(),
                            req.getPassword(),
                            req.getRoles(),
                            req.getImage(),
                            StaticStatus.STATUS_ACTIVE
                    );
                    if (request.getImage() != "") {
                        try {
                            imageService.addPicture(request.getImage(), users.getSku(), ImagePath.IMAGE_PATH_USER);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return usersRepo.save(users);
                });
    }

    @Override
    public Flux<Users> findAllCustomer() {
        return usersRepo.findAll().filter(data -> data.getRoles().toString().equals("ROLE_USER"));
    }

    @Override
    public Mono<Users> blockBySku(String sku) {
        return usersRepo.findFirstBySku(sku)
                .doOnNext(data -> {
                    usersRepo.deleteBySku(sku).subscribe();
                })
                .flatMap(data -> {
                    data.setStatus(StaticStatus.STATUS_BLOCKED);
                    return usersRepo.save(data);
                });
    }

    @Override
    public Mono<Users> activateBySku(String sku) {
        return  usersRepo.findFirstBySku(sku)
                .doOnNext(data -> {
                    usersRepo.deleteBySku(sku).subscribe();
                })
                .flatMap(data -> {
                    data.setStatus(StaticStatus.STATUS_ACTIVE);
                    return usersRepo.save(data);
                });
    }

}
