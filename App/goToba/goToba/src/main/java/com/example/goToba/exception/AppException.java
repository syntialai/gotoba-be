package com.example.goToba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/03/2020.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {
    public AppException(String message){
         super(message);
    }
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
