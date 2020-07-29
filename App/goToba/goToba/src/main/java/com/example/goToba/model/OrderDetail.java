package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class OrderDetail {
    Integer id;
    String sku ;
    String ticketSku;
    Integer quantity;
    Integer price;
    Integer discount;
    String merchantSku;
    String category;
    String wisataSku;
    String image;
    String userSku;
    Integer status;
    Boolean redeem;
    String expiredDate;
    String title;

}
