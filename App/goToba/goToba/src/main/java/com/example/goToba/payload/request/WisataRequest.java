package com.example.goToba.payload.request;

import com.example.goToba.model.HoursOpen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class WisataRequest {
    public String name;
    public String title;
    public String description;
    public String image;
    public String longitude;
    public String latitude;
    public String address;
    public String createdBy;
    public int price;
    public HoursOpen hoursOpen;

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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public HoursOpen getHoursOpen() {
        return hoursOpen;
    }

    public void setHoursOpen(HoursOpen hoursOpen) {
        this.hoursOpen = hoursOpen;
    }
}
