package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/04/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoursOpen {
        String[] Monday;
        String[] Tuesday;
        String[] Wednesday;
        String[] Thursday;
        String[] Friday;
        String[] Saturday;
        String[] Sunday;
}
