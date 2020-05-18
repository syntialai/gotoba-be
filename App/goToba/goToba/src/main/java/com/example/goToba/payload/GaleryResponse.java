package com.example.goToba.payload;

import com.example.goToba.model.Galery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/04/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GaleryResponse<T> {
    Integer code;
    String status;
    T data;

}
