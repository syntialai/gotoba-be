package com.example.goToba.service.redisService.implement;

import com.example.goToba.model.Galery;
import com.example.goToba.redis.template.RedisKeys;
import com.example.goToba.service.redisService.GaleryServiceRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by Sogumontar Hendra Simangunsong on 01/05/2020.
 */
@Service
public class GaleryServiceRedisImpl implements GaleryServiceRedis {
    String key = RedisKeys.REDIS_KEYS_FOR_GALERY;
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    private ListOperations listOperations;

    @Autowired
    public GaleryServiceRedisImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(Galery galery) {
        System.out.println(galery);
        hashOperations.put(key,galery.getSku(),galery);
    }

    @Override
    public Mono<?> findById(String id) {
        return Mono.fromCallable(() -> hashOperations.get(key,id));
//        return  hashOperations.get(key,id);
    }

    @Override
    public Map<Object, Object> findAll() {
        return  hashOperations.entries(key);
    }

    @Override
    public Boolean hasKey(String id) {
        return hashOperations.hasKey(key,id);
    }

    @Override
    public void delete(String key) {
        hashOperations.delete(this.key,key);
    }
}
