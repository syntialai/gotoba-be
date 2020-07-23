package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/06/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    Integer total;
    String status;
    String merchantSku;
    String orderSku;

}
