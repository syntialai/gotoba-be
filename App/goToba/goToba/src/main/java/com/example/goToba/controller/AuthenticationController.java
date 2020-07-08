package com.example.goToba.controller;


import com.example.goToba.controller.route.AuthenticationControllerRoute;
import com.example.goToba.controller.route.UserControllerRoute;
import com.example.goToba.model.UserRole;
import com.example.goToba.payload.AuthenticationResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.LoginRequest;
import com.example.goToba.payload.request.RegisterRequest;
import com.example.goToba.repository.SequenceUsersRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.UserService;
import com.example.goToba.service.implement.UserServiceImpl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@CrossOrigin
@RestController
@RequestMapping(AuthenticationControllerRoute.ROUTE_AUTH)
public class AuthenticationController extends HttpServlet {
    @Autowired
    UserService userService;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Autowired
    UsersRepo usersRepo;

    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_UP)
    public ResponseEntity<?> signup(@RequestBody RegisterRequest registerRequest) {
        userService.save(registerRequest).subscribe();
        return ResponseEntity.ok().body(new AuthenticationResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGE_USER_REGISTERED));
    }

    @PostMapping(value = AuthenticationControllerRoute.ROUTE_SIGN_IN)
    public Mono<ResponseEntity<?>> signin(@RequestBody LoginRequest request) {
        System.out.println("test");
        return userService.signin(request);
    }


    @PostMapping(value = "/test")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequest loginRequest
    ) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        return userService.login(loginRequest);
    }


    @CrossOrigin
    @GetMapping("/writeCookie/{key}")
    public ResponseEntity<?> writeCookie(@PathVariable String key) {
        System.out.println(key);
        String favColour = "steelblue";
        ResponseCookie cookie = ResponseCookie.from("fav-col", key).build();
        HttpHeaders httpHeaders= new HttpHeaders();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
//        httpHeaders.add(HttpHeaders.SET_COOKIE,cookie.toString());
//        return usersRepo.findFirstBySku(key).map(data -> {
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
//                    .build();
//        });
    }

    @CrossOrigin
    @GetMapping("/writeCookies/{key}")
    public ResponseEntity<?> writeCookies(@PathVariable String key) {
        return userService.test();

    }
    @PostMapping("/logout")
    public static void myLogoff(HttpServletRequest request, HttpServletResponse response) {
        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        cookieClearingLogoutHandler.logout(request, response, null);
        securityContextLogoutHandler.logout(request, response, null);
    }

}
