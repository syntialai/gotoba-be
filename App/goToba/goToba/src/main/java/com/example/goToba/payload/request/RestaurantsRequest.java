package com.example.goToba.payload.request;

import com.example.goToba.model.HoursOpen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class RestaurantsRequest {
    public String name;
    public String bistroType;
    public String longitude;
    public String latitude;
    public String address;
    public HoursOpen hoursOpen;
    public String phone;
}
