package com.example.goToba.model.elastic;

import com.example.goToba.model.WisataHoursOpen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/05/2020.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "gotoba", type = "wisata")
public class Wisata {
    @Id
    public String skuWisata;

    public String name;

    public String title;

    public String description;

    public String image;

    public String address;

    public String createdBy;

    public int price;

    public WisataHoursOpen hoursOpen;

}
