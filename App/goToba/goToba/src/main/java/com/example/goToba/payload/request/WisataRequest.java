package com.example.goToba.payload.request;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
public class WisataRequest {
    public String name;
    public String title;
    public String description;
    public String image;
    public String address;
    public String createdBy;
    public int price;
    public List hoursOpen;

    public WisataRequest(String name, String title, String description, String image, String address, String createdBy, int price, List hoursOpen) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.image = image;
        this.address = address;
        this.createdBy = createdBy;
        this.price = price;
        this.hoursOpen = hoursOpen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List getHoursOpen() {
        return hoursOpen;
    }

    public void setHoursOpen(List hoursOpen) {
        this.hoursOpen = hoursOpen;
    }
}
