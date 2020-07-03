package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 03/07/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DuplicateResponse {
    String timestamp;
    Integer status;
    String error;
    String message;
    String path;
}
