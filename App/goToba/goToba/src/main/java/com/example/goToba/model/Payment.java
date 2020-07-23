package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    Integer id;
    String sku;
    Integer total;
    String status;
    String orderSku;
    String merchantSku;
    String userSku;

}
