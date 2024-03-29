package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document
public class MenuRestaurants {
    private Integer id;
    private String name;
    private String image;
    private String category;
    private String harga;
    private String status;
    private String restaurantSku;
    private String merchantSku;

}
