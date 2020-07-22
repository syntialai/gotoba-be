package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 12/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {
    Integer id;
    String sku;
    String title;
    String description;
    String category;
    Integer price;
    Integer discount ;
    String expiredDate;
    String merchantSku;
    String createdAt;
    String wisataSku;
    String status;
    String orderSku;
    String image;

}
