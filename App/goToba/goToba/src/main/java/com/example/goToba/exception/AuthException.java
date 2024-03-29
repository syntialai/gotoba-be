package com.example.goToba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthException extends RuntimeException{

    public AuthException(String msg) {
        super(msg);
    }
}
