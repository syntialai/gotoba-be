package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuRestaurantsRequest {
    private String name;
    private String picture;
    private String category;
    private String harga;
    private String status;
    private String restoranSku;
    private String merchantSku;
}
