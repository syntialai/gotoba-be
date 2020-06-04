package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 27/05/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWithMessages<T> {
    private Integer code;
    private String status;
    private T data;
    private String message;
}
