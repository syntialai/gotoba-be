package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TravellingSchedule {
    Integer id;
    String sku;
    String date;
    List<Schedule> schedule;
    String userSku;
    String status;
}
