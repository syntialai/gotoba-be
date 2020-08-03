package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailRequest {
    String ticketSku;
    Integer quantity;
    Integer price;
    Integer discount;
    String merchantSku;
    String category;
    String wisataSku;
    String image;
    String userSku;
    String expiredDate;
    String title;

}
