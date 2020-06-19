package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/06/2020.
 */
@Data
@NoArgsConstructor
public class NotFoundResponse {
    String timestamp;
    Integer status;
    String error;
    String message;
    String path;

    public NotFoundResponse(String timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
