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
                            req.getKey() + "_" + "000" + (Integer.parseInt(req.getLast_seq())),
                            request.getNickname(),
                            request.getUsername(),
                            request.getEmail(),
                            request.getPassword(),
                            RoleName.ROLE_CUSTOMER,
                            1
                    );
                     return usersRepo.save(users);
                });
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
