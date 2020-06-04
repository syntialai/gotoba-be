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
        String[] monday;
        String[] tuesday;
        String[] wednesday;
        String[] thursday;
        String[] friday;
        String[] saturday;
        String[] sunday;

}
