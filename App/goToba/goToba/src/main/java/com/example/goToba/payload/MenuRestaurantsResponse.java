package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuRestaurantsResponse<T> {
    private Integer code;
    private String status;
    private T data;
    private String message;
}
