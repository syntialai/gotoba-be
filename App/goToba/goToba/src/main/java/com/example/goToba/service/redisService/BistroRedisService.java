package com.example.goToba.service.redisService;

import com.example.goToba.model.BistroTypes;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
public interface BistroRedisService<T> {
    Mono<T> findByName(String name);
    void add(BistroTypes bistroTypes);
    public List<BistroTypes> findAll();
    public Boolean hasKey(String key);
}
