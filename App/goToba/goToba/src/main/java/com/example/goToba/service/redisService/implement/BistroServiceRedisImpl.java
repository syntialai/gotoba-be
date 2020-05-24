package com.example.goToba.service.redisService.implement;

import com.example.goToba.model.BistroTypes;
import com.example.goToba.redis.template.RedisKeys;
import com.example.goToba.service.redisService.BistroRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Service
public class BistroServiceRedisImpl  implements BistroRedisService {
    String key = RedisKeys.REDIS_KEYS_FOR_BISTRO_TYPES;
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    private ListOperations listOperations;

    @Autowired
    public BistroServiceRedisImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(BistroTypes bistroTypes) {
        hashOperations.put(key,bistroTypes.getName(),bistroTypes);
    }
    @Override
    public Mono<?> findByName(String name) {
        return Mono.fromCallable(() -> hashOperations.get(key,name));
    }

    @Override
    public List< BistroTypes> findAll() {
        return  hashOperations.values(key);
    }

    @Override
    public Boolean hasKey(String key) {
        return hashOperations.hasKey(this.key,key);
    }

}
