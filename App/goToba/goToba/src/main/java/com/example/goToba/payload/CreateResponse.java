package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Builder
@Data
@AllArgsConstructor
public class CreateResponse {
    String timestamp;
    String code;
    String status;
    String message;

    public CreateResponse(String timestamp, String code, String status, String message) {
        this.timestamp = timestamp;
        this.code = code;
        this.status = status;
        this.message = message;
    }
}