package com.example.goToba.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@Builder
@Data
public class Wisata {
    public String skuWisata;
    public String name;
    public String title;
    public String description;
    public String image;
    public String address;
    public String createdBy;
    public int price;
    public HoursOpen hoursOpen;

   public Wisata(){

   }
    public Wisata(String skuWisata, String name, String title, String description, String image, String address, String createdBy, int price, HoursOpen hoursOpen) {
        this.skuWisata = skuWisata;
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
