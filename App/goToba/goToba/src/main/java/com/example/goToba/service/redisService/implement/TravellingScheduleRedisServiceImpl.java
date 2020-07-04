package com.example.goToba.service.redisService.implement;

import com.example.goToba.model.TravellingSchedule;
import com.example.goToba.payload.request.ScheduleRequest;
import com.example.goToba.redis.template.RedisKeys;
import com.example.goToba.service.TravellingScheduleService;
import com.example.goToba.service.redisService.TravellingScheduleRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 03/07/2020.
 */
@Service
public class TravellingScheduleRedisServiceImpl implements TravellingScheduleRedisService {

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations hashOperations;

    @Autowired
    public TravellingScheduleRedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void add(TravellingSchedule travellingSchedule) {
        hashOperations.put(RedisKeys.REDIS_KEYS_FOR_TRAVELLING_SCHEDULE,travellingSchedule.getId(),travellingSchedule);
    }

    @Override
    public Mono<?> findById(Integer id) {
        return Mono.fromCallable(() -> hashOperations.get(RedisKeys.REDIS_KEYS_FOR_TRAVELLING_SCHEDULE,id));
    }

    @Override
    public List<?> findAll() {
        return hashOperations.values(RedisKeys.REDIS_KEYS_FOR_TRAVELLING_SCHEDULE);
    }

    @Override
    public Boolean hasKey(Integer id) {
        return hashOperations.hasKey(RedisKeys.REDIS_KEYS_FOR_TRAVELLING_SCHEDULE,id);
    }

    @Override
    public void deleteByKey(Integer id) {
        hashOperations.delete(RedisKeys.REDIS_KEYS_FOR_TRAVELLING_SCHEDULE,id);
    }
}
