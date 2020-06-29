package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuRestaurants {
    private Integer id;
    private String name;
    private String picture;
    private String category;
    private String harga;
    private String status;
    private String restaurantSku;
    private String merchantSku;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRestaurantSku() {
        return restaurantSku;
    }

    public void setRestaurantSku(String restaurantSku) {
        this.restaurantSku = restaurantSku;
    }

    public String getMerchantSku() {
        return merchantSku;
    }

    public void setMerchantSku(String merchantSku) {
        this.merchantSku = merchantSku;
    }
}
