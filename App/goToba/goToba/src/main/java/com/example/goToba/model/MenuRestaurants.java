package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String restoranSku;
    private String merchantSku;


}
