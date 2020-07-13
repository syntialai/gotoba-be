package com.example.goToba.model.elastic;

import com.example.goToba.model.HoursOpen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Sogumontar Hendra Simangunsong on 04/07/2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "gotoba", type = "wisata", shards = 3)
public class WisataElastic {
    @Id
    public String sku;
    public String name;
    public String title;
    public String description;
    public String image;
    public Double longitude;
    public Double latitude;
    public String address;
    public String createdBy;
    public int price;
    public HoursOpen hoursOpen;
    public String status;

}

