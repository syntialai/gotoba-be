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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
