package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Galery {
    public Integer id;
    public String sku;
    public String name;
    public String title;
    public String description;
    public String image;
    public Boolean show = true;


}
