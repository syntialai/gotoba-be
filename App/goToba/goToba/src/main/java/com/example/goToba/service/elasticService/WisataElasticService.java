package com.example.goToba.service.elasticService;

import com.example.goToba.model.elastic.WisataElastic;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/05/2020.
 */
public interface WisataElasticService {
    List<WisataElastic> findOne(String nama);
    Iterator<WisataElastic> findAll();
    WisataElastic save(WisataElastic wisata);
    Boolean deleteBySku(String sku);
    WisataElastic findBySku(String sku);
}
