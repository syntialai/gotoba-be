package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteResponse {
    private Integer code;
    private String status;
    private String message;
}
