package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */
@Data
@NoArgsConstructor
public class AuthenticationResponse {
    String timestamp;
    Integer code;
    String status;
    String message;

    public AuthenticationResponse(String timestamp, Integer code, String status, String message) {
        this.timestamp = timestamp;
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
