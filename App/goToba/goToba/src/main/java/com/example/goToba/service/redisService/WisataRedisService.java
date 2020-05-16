package com.example.goToba.service.redisService;

import com.example.goToba.model.Wisata;

import java.util.Map;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/05/2020.
 */
public interface WisataRedisService {
    void add(Wisata wisata);
    Wisata findByKey(String key);
    Map<Object,Object> findAll();
    Boolean hasKey(String key);
    void deleteByKey(String key);
}