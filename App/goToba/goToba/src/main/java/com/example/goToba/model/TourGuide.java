package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TourGuide {
     Integer id;
     String sku;
     String name;
     Integer age;
     String occupation;
     String location;
     Double rating;
     List<String> language;
     List<String> availableLocation;
     String phone;
     String email;
     String whatsapp;
     String experience;
     String description;
     String status;
     String gender;
     String image;

}
