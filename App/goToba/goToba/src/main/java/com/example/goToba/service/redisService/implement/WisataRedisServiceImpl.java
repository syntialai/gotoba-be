package com.example.goToba.service.redisService.implement;

import com.example.goToba.model.Wisata;
import com.example.goToba.redis.template.RedisKeys;
import com.example.goToba.service.redisService.WisataRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/05/2020.
 */
@Service
public class WisataRedisServiceImpl implements WisataRedisService {

    String redisKey = RedisKeys.REDIS_KEYS_FOR_WISATA;
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public WisataRedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(Wisata wisata) {
        hashOperations.put(redisKey,wisata.getSku(),wisata);
    }

    @Override
    public Mono<?> findByKey(String key) {
        return Mono.fromCallable(() -> hashOperations.get(redisKey,key));
    }

    @Override
    public List<?> findAll() {
        return hashOperations.values(redisKey);
    }

    @Override
    public Boolean hasKey(String key) {
        return hashOperations.hasKey(redisKey,key);
    }

    @Override
    public void deleteByKey(String key) {
        hashOperations.delete(redisKey,key);
    }
}
