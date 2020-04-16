package com.example.goToba.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Builder
@Data
public class Galery {
    public String sku = UUID.randomUUID().toString();
    public String name;
    public String title;
    public String description;
    public String image;
    public Boolean show = true;

}
