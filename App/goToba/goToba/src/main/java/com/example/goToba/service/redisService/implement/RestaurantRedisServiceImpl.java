package com.example.goToba.service.redisService.implement;

import com.example.goToba.model.Restaurant;
import com.example.goToba.redis.template.RedisKeys;
import com.example.goToba.service.redisService.RestaurantRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Service
public class RestaurantRedisServiceImpl implements RestaurantRedisService {
    String redisKey = RedisKeys.REDIS_KEYS_FOR_RESTAURANTS;
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    @Autowired
    public RestaurantRedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(Restaurant restaurant) {
        hashOperations.put(redisKey,restaurant.getSku(),restaurant);
    }

    @Override
    public Mono<?> findById(String id) {
        return Mono.fromCallable(() -> hashOperations.get(redisKey,id));
    }

    @Override
    public List<Restaurant> findAll() {
        return hashOperations.values(redisKey);
    }

    @Override
    public Boolean hasKey(String key) {
        return hashOperations.hasKey(redisKey,key);
    }

    @Override
    public void delete(String key) {
        hashOperations.delete(redisKey,key);
    }
}
