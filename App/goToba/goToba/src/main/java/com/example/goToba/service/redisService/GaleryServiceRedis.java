package com.example.goToba.service.redisService;

import com.example.goToba.model.Galery;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Created by Sogumontar Hendra Simangunsong on 01/05/2020.
 */
@Service
public interface GaleryServiceRedis {
    void add(Galery galery);
    Mono<Galery> findById(String id);
    Map<Object, Object> findAll();
    Boolean hasKey(String key);
    void delete(String key);
}
