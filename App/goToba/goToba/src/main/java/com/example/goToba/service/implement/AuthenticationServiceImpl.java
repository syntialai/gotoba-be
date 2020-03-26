package com.example.goToba.service.implement;

import com.example.goToba.exception.AppException;
import com.example.goToba.model.RoleName;
import com.example.goToba.model.Roles;
import com.example.goToba.model.SequenceUsers;
import com.example.goToba.model.Users;
import com.example.goToba.payload.ApiResponse;
import com.example.goToba.payload.RegisterRequest;
import com.example.goToba.repository.RoleRepo;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/03/2020.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    SequenceUsersRepo sequenceUsersRepo;

    @Override
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){

        checkEmail(registerRequest.getEmail());
        checkUsername(registerRequest.getUsername());

        Roles roles =checkRole(registerRequest.getRole().toString());
        String skuFix=skuGenerator(registerRequest.getUsername(),roles.toString());
        Users users=new Users(
                skuFix,
                registerRequest.getNickname(),
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                1
                );

        users.setRoles(Collections.singleton(roles));


        return ResponseEntity.ok(usersRepo.save(users));
    }

    @Override
    public Roles checkRole(String role){
        Roles roles;
        RoleName roleName=RoleName.ROLE_USER;
        if(role.equals(RoleName.ROLE_ADMIN)){
            roleName=RoleName.ROLE_ADMIN;
        }else if(role.equals(RoleName.ROLE_MERCHANT)){
            roleName=RoleName.ROLE_MERCHANT;
        }
        roles = roleRepo.findByName(roleName)
                .orElseThrow(() -> new AppException("User Role not set."));
        return roles;
    }

    @Override
    public String skuGenerator(String username,String role){
        String skuFinal="";
        String usr=sub_str(username);
        String awal="000";
        if(sequenceUsersRepo.existsByKey(usr)){
            SequenceUsers sequenceUsers = sequenceUsersRepo.findFirstByKey(usr);
            Integer val = Integer.parseInt(sequenceUsers.getLast_seq());
            String finalSeq = awal.concat(String.valueOf(val+1));
            sequenceUsers.setLast_seq(finalSeq);
            sequenceUsersRepo.save(sequenceUsers);

            skuFinal = usr+"-"+finalSeq ;
        }else{
            SequenceUsers sequenceUsers=new SequenceUsers(usr,"0001");
            sequenceUsersRepo.save(sequenceUsers);
            skuFinal = usr+"-0001";
        }

        return  skuFinal;
    }

    @Override
    public ResponseEntity<?> checkUsername(String username) {
        if(usersRepo.existsByUsername(username)){
            return new ResponseEntity(new ApiResponse(false,"Username is Already Taken!"),
            HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> checkEmail(String email) {
        if(usersRepo.existsByEmail(email)){
            return new ResponseEntity(new ApiResponse(false,"Email Address Already In Use!"),
                    HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @Override
    public String sub_str(String str) {
        return str.substring(0,4).toUpperCase();
    }
}
