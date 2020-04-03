package com.example.goToba.controller;

import com.example.goToba.controller.route.AuthenticationControllerRoute;
import com.example.goToba.exception.AuthException;
import com.example.goToba.model.Users;
import com.example.goToba.payload.JwtLoginResponse;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.repository.TestingMultiple;
import com.example.goToba.security.JwtTokenProvider;
import com.example.goToba.security.UserPrincipal;
import com.example.goToba.service.implement.AuthenticationServiceImpl;
import com.example.goToba.service.implement.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/03/2020.
 */
@CrossOrigin
@RestController
@RequestMapping(AuthenticationControllerRoute.ROUTE_AUTH)
public class AuthenticationController {

    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    TestingMultiple testingMultiple;
     @GetMapping("/test/{username}")
     public Users findwithUsername(@PathVariable String username){
         return usersService.findByUsername(username);
     }

    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_UP)
    public ResponseEntity<?> register(@RequestBody  RegisterRequest registerRequest){
        return authenticationService.register(registerRequest);
    }

    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_IN)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
//        System.out.println("username : " + loginRequest.getUsername());
//        System.out.println("password : " + loginRequest.getPassword());
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        System.out.println("testing");
//        Users user = usersService.findByUsername(loginRequest.getUsername());
//        String role=user.getRoles().toString();
//        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//        if (userPrincipal.getStatus()!=1) throw new AuthException("User has been blocked");
//        String token=jwtTokenProvider.generateToken(authentication);
//        return ResponseEntity.ok(new JwtLoginResponse(
//                token,
//                role,
//                userPrincipal.getSku(),
//                userPrincipal.getStatus(),
//                userPrincipal.getName(),
//                userPrincipal.getEmail())
//        );
    }
//    @PostMapping("/test")
//    public String test(@RequestBody TestTable testTable){
//        TestTable testTable1=new TestTable("asd");
//        testingMultiple.save( testTable1).subscribe();
//        return "Sukses";
//    }

}
