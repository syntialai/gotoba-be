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
public class OrderDetail {
    Integer id;
    String sku;
    Integer quantity;
    Integer price;
    Integer ticketId;
    String merchantSku;
    String userSku;


}
