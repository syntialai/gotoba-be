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
    Integer merchantId;
    String merchantSku;
    Integer userId;
    String userSku;

    public OrderDetail(Integer id, String sku, Integer quantity, Integer price, Integer ticketId, String userSku) {
        this.id = id;
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.ticketId = ticketId;
        this.userSku = userSku;
    }

}
