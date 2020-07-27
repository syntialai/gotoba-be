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
    public Double longitude;
    public Double latitude;
    private Double rating;
    private String address;
    private HoursOpen hoursOpen;
    private String phone;
    private String status;
    private String merchantSku;
    private String image;

}
