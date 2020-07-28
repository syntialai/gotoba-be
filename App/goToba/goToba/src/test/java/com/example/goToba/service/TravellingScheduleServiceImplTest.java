package com.example.goToba.service;

import com.example.goToba.model.TravellingSchedule;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.repository.SequenceTravellingScheduleRepo;
import com.example.goToba.repository.TravellingScheduleRepo;
import com.example.goToba.service.implement.TravellingScheduleServiceImpl;
import com.example.goToba.service.redisService.TravellingScheduleRedisService;
import com.example.goToba.service.utils.SkuGenerator;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
public class TravellingScheduleServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    TravellingScheduleRepo travellingScheduleRepo;

    @Mock
    TravellingScheduleRedisService travellingScheduleRedisService;

    @Mock
    SkuGenerator skuGenerator;

    @Mock
    SequenceTravellingScheduleRepo sequencetravellingScheduleRepo;

    @InjectMocks
    TravellingScheduleServiceImpl travellingScheduleService;

    @Ignore
    @Test
    public void findAllTest(){
        TravellingSchedule travellingSchedule = TravellingSchedule.builder().status(StaticStatus.STATUS_ACTIVE).build();
        when(travellingScheduleRepo.findAll()).thenReturn(Flux.just(travellingSchedule));
        StepVerifier.create(travellingScheduleService.findAll())
                .expectNext(travellingSchedule)
                .expectComplete()
                .verify();
        verify(travellingScheduleRepo).findAll();
    }
}
