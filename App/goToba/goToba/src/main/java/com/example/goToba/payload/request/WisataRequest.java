package com.example.goToba.payload.request;

import com.example.goToba.model.WisataHoursOpen;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@NoArgsConstructor
@Data
public class WisataRequest {
    public String name;
    public String title;
    public String description;
    public String image;
    public String address;
    public String createdBy;
    public int price;
    public WisataHoursOpen hoursOpen;

    public WisataRequest(String name, String title, String description, String image, String address, String createdBy, int price, WisataHoursOpen hoursOpen) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.image = image;
        this.address = address;
        this.createdBy = createdBy;
        this.price = price;
        this.hoursOpen = hoursOpen;
    }


}
