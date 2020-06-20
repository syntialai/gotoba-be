package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reviews {
    Integer id;
    Double rating;
    String comment;
    Integer merchantId;
    String merchantSku;
    Integer userId;
    String userSku;
}
