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
    public Double longitude;
    public Double latitude;
    public String address;
    public String createdBy;
    public int price;
    public HoursOpen hoursOpen;

}
