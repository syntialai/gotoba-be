package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravellingSchedule {
    Integer id;
    String title;
    String description;
    String vacationDestination;
    String skuCustomer;
}
