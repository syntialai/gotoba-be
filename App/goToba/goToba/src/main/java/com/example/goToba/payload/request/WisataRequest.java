package com.example.goToba.payload.request;

import com.example.goToba.model.WisataHoursOpen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class WisataRequest {
    public String name;
    public String title;
    public String description;
    public String image;
    public String address;
    public String createdBy;
    public int price;
    public WisataHoursOpen hoursOpen;

}
