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
    String wisataSku;

    public String getTicketSku() {
        return ticketSku;
    }

    public void setTicketSku(String ticketSku) {
        this.ticketSku = ticketSku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getMerchantSku() {
        return merchantSku;
    }

    public void setMerchantSku(String merchantSku) {
        this.merchantSku = merchantSku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWisataSku() {
        return wisataSku;
    }

    public void setWisataSku(String wisataSku) {
        this.wisataSku = wisataSku;
    }
}
