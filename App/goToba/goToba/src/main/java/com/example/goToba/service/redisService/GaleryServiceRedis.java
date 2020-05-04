package com.example.goToba.service.redisService;

import com.example.goToba.model.Galery;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Sogumontar Hendra Simangunsong on 01/05/2020.
 */
@Service
public interface GaleryServiceRedis {
    void add(Galery galery);
    Galery findById(String id);
    Map<Object, Object> findAll();
    Boolean hasKey(String key);
    void delete(String key);
}
