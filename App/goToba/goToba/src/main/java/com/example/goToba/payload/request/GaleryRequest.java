package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GaleryRequest {
    public String name;
    public String title;
    public String description;
    public String image;
    public Boolean show;
}
