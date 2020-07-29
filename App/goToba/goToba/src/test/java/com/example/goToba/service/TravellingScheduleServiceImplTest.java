package com.example.goToba.service;
import com.example.goToba.model.RoleName;
import com.example.goToba.model.TravellingSchedule;
import com.example.goToba.model.Users;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.repository.SequenceTravellingScheduleRepo;
import com.example.goToba.repository.TravellingScheduleRepo;
import com.example.goToba.repository.UsersRepo;
import com.example.goToba.service.implement.TravellingScheduleServiceImpl;
import com.example.goToba.service.redisService.TravellingScheduleRedisService;
import com.example.goToba.service.utils.SkuGenerator;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
@ExtendWith(MockitoExtension.class)
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
    UsersRepo usersRepo;

    @Mock
    SequenceTravellingScheduleRepo sequencetravellingScheduleRepo;

    @InjectMocks
    TravellingScheduleServiceImpl travellingScheduleService;

    TravellingSchedule travellingSchedule = TravellingSchedule.builder().status(StaticStatus.STATUS_ACTIVE).build();

    @Test
    public void findAllTest(){
        when(travellingScheduleRepo.findAll()).thenReturn(Flux.just(travellingSchedule).filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE)));
        StepVerifier.create(travellingScheduleService.findAll())
                .expectNext(travellingSchedule)
                .expectComplete()
                .verify();
        verify(travellingScheduleRepo).findAll();
    }

    @Test
    public void findByScheduleSkuTest(){
        when(travellingScheduleRedisService.hasKey("key")).thenReturn(false);
        when(travellingScheduleRepo.findBySku("key")).thenReturn(Mono.just(travellingSchedule));
        StepVerifier.create(travellingScheduleService.findByScheduleSku("key"))
                .consumeNextWith(data -> {
                    assertEquals(data,travellingSchedule);
                })
                .expectComplete()
                .verify();
        verify(travellingScheduleRedisService).add(travellingSchedule);
    }
}
