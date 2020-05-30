package com.example.goToba.service.implement;

import com.example.goToba.model.TravellingSchedule;
import com.example.goToba.repository.TravellingScheduleRepo;
import com.example.goToba.service.TravellingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Service
public class TravellingScheduleServiceImpl implements TravellingScheduleService {

    @Autowired
    TravellingScheduleRepo travellingScheduleRepo;

    @Override
    public Flux<TravellingSchedule> findAllBySku(String sku) {
        return travellingScheduleRepo.findAllBySkuCustomer(sku);
    }

    @Override
    public Mono<TravellingSchedule> findByScheduleId(String id) {
        return null;
    }

    @Override
    public Mono<TravellingSchedule> updateById(String id) {
        return null;
    }
}
