package com.example.goToba.service.redisService;

import com.example.goToba.model.Galery;
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
}
