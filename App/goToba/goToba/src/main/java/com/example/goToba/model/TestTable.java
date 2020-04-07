package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/03/2020.
 */

@Data
@Builder
@NoArgsConstructor
@Document
public class TestTable {
    @Column(name = "vale")
    private String vale;

    public TestTable(String vale) {
        this.vale = vale;
    }
}
