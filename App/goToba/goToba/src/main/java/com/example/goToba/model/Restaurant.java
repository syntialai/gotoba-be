package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
    private String sku;
    private String name;
    private String bistroType;
    private String location;
    private Double rating;
    private String address;
    private HoursOpen hoursOpen;
    private String phone;
    private String status;
    private String merchantSku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBistroType() {
        return bistroType;
    }

    public void setBistroType(String bistroType) {
        this.bistroType = bistroType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HoursOpen getHoursOpen() {
        return hoursOpen;
    }

    public void setHoursOpen(HoursOpen hoursOpen) {
        this.hoursOpen = hoursOpen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantSku() {
        return merchantSku;
    }

    public void setMerchantSku(String merchantSku) {
        this.merchantSku = merchantSku;
    }
}
