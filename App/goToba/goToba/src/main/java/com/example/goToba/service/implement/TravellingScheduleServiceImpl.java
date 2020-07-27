package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceTravellingSchedule;
import com.example.goToba.model.TravellingSchedule;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.request.ScheduleRequest;
import com.example.goToba.repository.SequenceTravellingScheduleRepo;
import com.example.goToba.repository.TravellingScheduleRepo;
import com.example.goToba.service.TravellingScheduleService;
import com.example.goToba.service.redisService.TravellingScheduleRedisService;
import com.example.goToba.service.utils.SkuGenerator;
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

    @Autowired
    SkuGenerator skuGenerator;

    @Autowired
    SequenceTravellingScheduleRepo sequencetravellingScheduleRepo;

    @Override
    public Flux<TravellingSchedule> findAll() {
        return travellingScheduleRepo.findAll()
                .filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE));
    }

    @Override
    public Mono<TravellingSchedule> findByScheduleSku(String sku) {
        if (travellingScheduleRedisService.hasKey(sku)) {
            return travellingScheduleRedisService.findBySku(sku);
        }
        return travellingScheduleRepo.findBySku(sku).map(data -> {
            travellingScheduleRedisService.add(data);
            return data;
        });
    }



    @Override
    public Mono<TravellingSchedule> addBySku(String sku, ScheduleRequest scheduleRequest) {

        String key = skuGenerator.substring(StockKeepingUnit.TRAVELLING_SCHEDULE) + StockKeepingUnit.SKU_CONNECTOR + skuGenerator.substring(sku);
        return Mono.fromCallable(() -> scheduleRequest)
                .flatMap(dat -> sequencetravellingScheduleRepo.findFirstByKey(key))
                .doOnNext(dat -> sequencetravellingScheduleRepo.deleteByKey(key).subscribe())
                .doOnNext(dat -> sequencetravellingScheduleRepo.save(new SequenceTravellingSchedule(key, StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(dat.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequencetravellingScheduleRepo.save(new SequenceTravellingSchedule(key, StockKeepingUnit.SKU_FIRST_DATA)))
                .flatMap(dat -> sequencetravellingScheduleRepo.findFirstByKey(key))
                .flatMap(data -> {
                    TravellingSchedule schedule1 = new TravellingSchedule(
                            (int) UUID.randomUUID().getMostSignificantBits(),
                            data.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(data.getLast_seq()),
                            scheduleRequest.getDate(),
                            scheduleRequest.getSchedule(),
                            sku,
                            StaticStatus.STATUS_ACTIVE
                    );
                    return travellingScheduleRepo.save(schedule1);
                });
    }

    @Override
    public Mono<TravellingSchedule> editBySku(String sku, ScheduleRequest scheduleRequest) {
        return Mono.fromCallable(() -> scheduleRequest)
                .flatMap(data -> travellingScheduleRepo.findBySku(sku))
                .flatMap(data -> {
                    travellingScheduleRepo.deleteBySku(sku);
                    TravellingSchedule schedule = new TravellingSchedule(
                            data.getId(),
                            sku,
                            scheduleRequest.getDate(),
                            scheduleRequest.getSchedule(),
                            data.getUserSku(),
                            data.getStatus()
                    );
                    travellingScheduleRedisService.deleteByKey(sku);
                    travellingScheduleRedisService.add(schedule);

                   return travellingScheduleRepo.save(schedule);
                });
    }


    @Override
    public Mono<TravellingSchedule> deleteBySku(String sku) {
        return travellingScheduleRepo.findBySku(sku)
                .flatMap(data -> {
                    travellingScheduleRepo.deleteBySku(sku);
                    data.setStatus(StaticStatus.STATUS_DELETE);
                    travellingScheduleRedisService.deleteByKey(sku);
                    return travellingScheduleRepo.save(data);
                });
    }
}
