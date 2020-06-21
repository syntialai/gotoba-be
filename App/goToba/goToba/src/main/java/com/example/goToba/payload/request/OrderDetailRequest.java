package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailRequest {
    List<OrderDetailTicket> ticket;
    String userSku;


    public List<OrderDetailTicket> getTicket() {
        return ticket;
    }

    public void setTicket(List<OrderDetailTicket> ticket) {
        this.ticket = ticket;
    }

    public String getUserSku() {
        return userSku;
    }

    public void setUserSku(String userSku) {
        this.userSku = userSku;
    }
}
