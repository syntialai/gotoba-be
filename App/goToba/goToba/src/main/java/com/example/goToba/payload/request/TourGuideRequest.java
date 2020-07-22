package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TourGuideRequest {
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
    String gender;
    String image;

}
