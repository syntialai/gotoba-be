package com.example.goToba.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleRequest {
    String title;
    String description;
    String date;
    String endDate;
    String vacationDestination;

}
