package com.example.goToba.service.elasticService;

import com.example.goToba.model.elastic.Wisata;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/05/2020.
 */
public interface WisataElasticService {
    List<Wisata> findOne(String nama);
    List<Wisata> findAll();
    Wisata save(Wisata wisata);
}
