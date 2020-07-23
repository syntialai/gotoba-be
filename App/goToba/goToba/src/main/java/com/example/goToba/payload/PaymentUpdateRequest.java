package com.example.goToba.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentUpdateRequest {
    Integer total;
    String status;
    String orderSku;
}
