package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wisata {
    public String sku;
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
    public String status;


    public com.example.goToba.model.elastic.Wisata toWisata(Wisata wisata){
        com.example.goToba.model.elastic.Wisata wisata1 = new com.example.goToba.model.elastic.Wisata(
                wisata.getSku(),
                wisata.getName(),
                wisata.getTitle(),
                wisata.getDescription(),
                wisata.getImage(),
                wisata.getLongitude(),
                wisata.getLatitude(),
                wisata.getAddress(),
                wisata.getCreatedBy(),
                wisata.getPrice(),
                wisata.getHoursOpen(),
                wisata.getStatus()
        );
        return wisata1;
    }

}
