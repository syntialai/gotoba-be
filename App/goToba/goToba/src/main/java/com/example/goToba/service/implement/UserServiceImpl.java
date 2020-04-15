package com.example.goToba.service.implement;

import com.example.goToba.model.RoleName;
import com.example.goToba.model.SequenceUsers;
import com.example.goToba.model.Users;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@Service
public class UserServiceImpl implements UserService {

    String skuFinal = "";

    @Autowired
    SequenceUsersRepo sequenceUsersRepo;

    @Autowired
    UsersRepo usersRepo;

    @Override
    public String skuGenerator(String username, String role) {
        String skuFinal = "";
        String usr = sub_str(username);
        String awal = "000";

        return skuFinal;
    }

    @Override
    public String sub_str(String str) {
        return str.substring(0, 4).toUpperCase();
    }

    @Override
    public ResponseEntity<?> save(RegisterRequest registerRequest) {
        Users users = new Users(
                "00" + skuFinal,
                registerRequest.getNickname(),
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                RoleName.ROLE_CUSTOMER,
                1
        );
        sequenceSku(sub_str(registerRequest.getUsername()), users);
        usersRepo.save(users).subscribe();
        return ResponseEntity.ok("Register Success");
    }

    @Override
    public Mono<Users> findByNickname(String nickname) {
        return usersRepo.findFirstByNickname(nickname)
                .doOnNext(i -> {
                    usersRepo.findFirstByNickname(nickname);
                });

    }

    @Override
    public Disposable sequenceSku(String key, Users users) {
        SequenceUsers sequenceUsers;
        final AtomicInteger[] last = {new AtomicInteger()};
        String lastStr = last[0].toString();
        skuFinal = key + "_" + lastStr;
        System.out.println(skuFinal);
        return sequenceUsersRepo.findFirstByKey(key)
                .doOnNext(i -> last[0].set(Integer.parseInt(i.getLast_seq()) + 1))
                .doOnNext(i -> skuFinal = key + "_" + last[0].toString())
                .doOnNext(i -> users.setSku(skuFinal))
                .doOnNext(i -> {
                    usersRepo.save(users);
                })
                .flatMap(b -> {
                    return sequenceUsersRepo.save(new SequenceUsers(key, "00" + last[0].toString()));
                })
                .switchIfEmpty(
                        sequenceUsersRepo.save(new SequenceUsers(key, "001"))
                ).subscribe();
    }
}
