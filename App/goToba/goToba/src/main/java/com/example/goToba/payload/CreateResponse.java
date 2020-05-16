package com.example.goToba.payload;

import com.example.goToba.payload.request.GaleryRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateResponse {
    Integer code;
    String status;
    GaleryRequest data;


}