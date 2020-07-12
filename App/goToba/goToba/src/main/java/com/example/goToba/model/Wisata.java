package com.example.goToba.model;

import com.example.goToba.model.elastic.WisataElastic;
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
    public Double longitude;
    public Double latitude;
    public String address;
    public String createdBy;
    public int price;
    public HoursOpen hoursOpen;
    public String status;


    public WisataElastic toWisata(Wisata wisata){
        WisataElastic wisata1 = new WisataElastic(
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
