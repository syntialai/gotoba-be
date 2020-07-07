package com.example.goToba.service;

import com.example.goToba.payload.Token;

import java.time.LocalDateTime;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/07/2020.
 */
public interface TokenProviderService {
    Token generateAccessToken(String subject);

    Token generateRefreshToken(String subject);

    String getUsernameFromToken(String token);

    LocalDateTime getExpiryDateFromToken(String token);

    boolean validateToken(String token);
}
