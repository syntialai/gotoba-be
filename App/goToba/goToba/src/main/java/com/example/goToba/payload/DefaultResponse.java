package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 20/05/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultResponse {
    private Integer code;
    private String message;
}
