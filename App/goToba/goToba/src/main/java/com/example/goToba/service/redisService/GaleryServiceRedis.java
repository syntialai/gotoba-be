package com.example.goToba.service.redisService;

import com.example.goToba.model.Galery;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * Created by Sogumontar Hendra Simangunsong on 01/05/2020.
 */
@Service
public interface GaleryServiceRedis<T> {
    void add(Galery galery);
    Mono<T> findById(String id);
    List< Object> findAll();
    Boolean hasKey(String key);
    void delete(String key);
}
