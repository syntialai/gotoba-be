package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class BistroTypes {
    private String id = UUID.randomUUID().toString();
    private String name;
}
