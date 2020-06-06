package com.example.goToba.payload;

import com.example.goToba.model.Restaurant;
import com.example.goToba.model.TourGuide;
import com.example.goToba.model.Users;
import com.example.goToba.model.Wisata;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Integer code;
    private String status;
    private T data;
}
