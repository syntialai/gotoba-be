package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketRequest {
    String title;
    String description;
    String category;
    Integer price;
    Integer discount;
    String expiredDate;
    String merchantSku;
    String wisataSku;
    String orderSku;

}
