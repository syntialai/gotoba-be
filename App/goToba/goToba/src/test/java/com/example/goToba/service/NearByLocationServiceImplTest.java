package com.example.goToba.service;

import com.example.goToba.service.implement.NearByLocationServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
@ExtendWith(MockitoExtension.class)
public class NearByLocationServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    NearByLocationServiceImpl nearByLocationService;

//    @Test
//    public void distanceTest(){
//        StepVerifier.create(nearByLocationService.distance(1,1,1,1))
//                .expectNext(orderDetail)
//                .expectComplete()
//                .verify();
//    }
}
