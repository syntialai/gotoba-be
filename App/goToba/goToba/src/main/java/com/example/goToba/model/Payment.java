package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class Payment {
    Integer id;
    String sku;
    Integer total;
    String status;
    String orderSku;
    String createdAt;
    String merchantSku;
    String userSku;

}
