package com.example.goToba.service.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/07/2020.
 */
@Component
public class CookieUtil {
    @Value("accessToken")
    private String accessTokenCookieName;

    @Value("refreshToken")
    private String refreshTokenCookieName;


    public HttpCookie createAccessTokenCookie(String token, Long duration) {
        String encryptedToken = SecurityChiper.encrypt(token);
        return ResponseCookie.from(accessTokenCookieName, encryptedToken)
                .maxAge(duration)
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie createRefreshTokenCookie(String token, Long duration) {
        String encryptedToken = SecurityChiper.encrypt(token);
        return ResponseCookie.from(refreshTokenCookieName, encryptedToken)
                .maxAge(duration)
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie deleteAccessTokenCookie() {
        return ResponseCookie.from(accessTokenCookieName, "").maxAge(0).httpOnly(true).path("/").build();
    }

}
