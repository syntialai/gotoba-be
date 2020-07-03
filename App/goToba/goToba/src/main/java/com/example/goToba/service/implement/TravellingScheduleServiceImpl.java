package com.example.goToba.service.implement;

import com.example.goToba.model.TravellingSchedule;
import com.example.goToba.payload.helper.Strings;
import com.example.goToba.payload.request.ScheduleRequest;
import com.example.goToba.repository.TravellingScheduleRepo;
import com.example.goToba.service.TravellingScheduleService;
import com.example.goToba.service.redisService.TravellingScheduleRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Service
public class TravellingScheduleServiceImpl implements TravellingScheduleService {

    @Autowired
    TravellingScheduleRepo travellingScheduleRepo;

    @Autowired
    TravellingScheduleRedisService travellingScheduleRedisService;

    @Override
    public Flux<TravellingSchedule> findAll() {
        return travellingScheduleRepo.findAll();
    }

    @Override
    public Mono<TravellingSchedule> findByScheduleId(Integer id) {
        if (travellingScheduleRedisService.hasKey(id)) {
            return travellingScheduleRedisService.findById(id);
        }
        return travellingScheduleRepo.findById(id).map(data -> {
            travellingScheduleRedisService.add(data);
            return data;
        });
    }

    @Override
    public Mono<TravellingSchedule> updateById(String id) {
        return null;
    }

    @Override
    public Mono<TravellingSchedule> addBySku(String sku, ScheduleRequest scheduleRequest) {
        Mono<TravellingSchedule> schedule = Mono.fromCallable(() -> scheduleRequest)
                .flatMap(data -> {
                    TravellingSchedule schedule1 = new TravellingSchedule(
                            (int) UUID.randomUUID().getMostSignificantBits(),
                            scheduleRequest.getTitle(),
                            scheduleRequest.getDescription(),
                            scheduleRequest.getDate(),
                            scheduleRequest.getEndDate(),
                            scheduleRequest.getVacationDestination(),
                            sku,
                            Strings.STATUS_ACTIVE
                    );
                    return travellingScheduleRepo.save(schedule1);
                });
        return schedule;
    }

    @Override
    public Mono<TravellingSchedule> editById(Integer id, ScheduleRequest scheduleRequest) {
        return Mono.fromCallable(() -> scheduleRequest)
                .flatMap(data -> travellingScheduleRepo.findById(id))
                .doOnNext(i -> {
                    travellingScheduleRepo.deleteById(id).subscribe();
                })
                .flatMap(data -> {
                    TravellingSchedule schedule = new TravellingSchedule(
                            id,
                            scheduleRequest.getTitle(),
                            scheduleRequest.getDescription(),
                            scheduleRequest.getDate(),
                            scheduleRequest.getEndDate(),
                            scheduleRequest.getVacationDestination(),
                            data.getUserSku(),
                            data.getStatus()
                    );
                    travellingScheduleRedisService.deleteByKey(id);
                    travellingScheduleRedisService.add(schedule);
                    return travellingScheduleRepo.save(schedule);
                });
    }

    @Override
    public Mono<TravellingSchedule> deleteById(Integer id) {
        return Mono.fromCallable(() -> id)
                .flatMap(data -> travellingScheduleRepo.findById(id))
                .doOnNext(i -> {
                    travellingScheduleRepo.deleteById(id).subscribe();
                })
                .flatMap(data -> {
                    TravellingSchedule schedule = new TravellingSchedule(
                            id,
                            data.getTitle(),
                            data.getDescription(),
                            data.getDate(),
                            data.getEndDate(),
                            data.getVacationDestination(),
                            data.getUserSku(),
                            Strings.STATUS_DELETE
                    );
                    travellingScheduleRedisService.deleteByKey(id);
                    return travellingScheduleRepo.save(schedule);
                });
    }
}
