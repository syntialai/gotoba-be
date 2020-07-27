package com.example.goToba.payload.request;

import com.example.goToba.model.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleRequest {
    String date;
    List<Schedule> schedule;
}
