package com.example.goToba.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Data
@NoArgsConstructor
public class GetAllDataResponse {
    String message;
    List data;

    public GetAllDataResponse(String message, List data) {
        this.message = message;
        this.data = data;
    }
}
