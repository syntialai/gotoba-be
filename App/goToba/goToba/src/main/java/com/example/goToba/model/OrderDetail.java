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
@NoArgsConstructor
@Data
public class OrderDetail {
    String sku ;
    List<OrderDetailTicket> ticket;
    String userSku;

    public OrderDetail(String sku, List<OrderDetailTicket> ticket, String userSku) {
        this.sku = sku;
        this.ticket = ticket;
        this.userSku = userSku;
    }


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUserSku() {
        return userSku;
    }

    public void setUserSku(String userSku) {
        this.userSku = userSku;
    }

    public List<OrderDetailTicket> getTicket() {
        return ticket;
    }

    public void setTicket(List<OrderDetailTicket> ticket) {
        this.ticket = ticket;
    }
}
