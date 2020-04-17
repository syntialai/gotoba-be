package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Galery {
    public String sku = UUID.randomUUID().toString();
    public String name;
    public String title;
    public String description;
    public String image;
    public Boolean show = true;

    public Galery(String name, String title, String description, String image, Boolean show) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.image = image;
        this.show = show;
    }
}
