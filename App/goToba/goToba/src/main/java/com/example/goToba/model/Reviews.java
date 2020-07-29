package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document
public class Reviews {
    Integer id;
    String targetSku;
    Double rating;
    String comment;
    String merchantSku;
    String userSku;

}
