package com.example.goToba.model;

import com.example.goToba.payload.request.OrderDetailTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {
    Integer id;
    String sku ;
    List<OrderDetailTicket> ticket;
    String userSku;
    String status;
}
