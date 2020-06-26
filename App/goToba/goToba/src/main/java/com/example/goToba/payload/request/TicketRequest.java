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
    String category;
    Integer price;
    String expiredDate;
    String merchantSku;
    String wisataSku;
    Integer orderId;
    String skuUser;
}
