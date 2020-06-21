package com.example.goToba.payload;

import com.example.goToba.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Data
@NoArgsConstructor
public class Response<T> {
    private Integer code;
    private String status;
    private T data;

    public Response(Integer code, String status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }
}
