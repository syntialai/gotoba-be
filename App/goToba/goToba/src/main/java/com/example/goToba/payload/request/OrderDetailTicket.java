package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 18/06/2020.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailTicket {
    String ticketSku;
    Integer quantity;
    Integer price;
    String merchantSku;
    String category;
}
