package com.example.goToba.service;

import com.example.goToba.model.TourGuide;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.repository.SequenceTourGuideRepo;
import com.example.goToba.repository.TourGuideRepo;
import com.example.goToba.service.implement.TourGuideServiceImpl;
import com.example.goToba.service.utils.SkuGenerator;
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
public class TourGuideServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    SkuGenerator skuGenerator;

    @Mock
    TourGuideRepo tourGuideRepo;

    @Mock
    SequenceTourGuideRepo sequenceTourGuideRepo;

    @Mock
    ImageService imageService;

    @InjectMocks
    TourGuideServiceImpl tourGuideService;

    private TourGuide tourGuide = TourGuide.builder().status(StaticStatus.STATUS_ACTIVE).build();

    @Test
    public void findAllTest() {
        when(tourGuideRepo.findAll()).thenReturn(Flux.just(tourGuide).filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE)));
        StepVerifier.create(tourGuideService.findAll())
                .expectNext(tourGuide)
                .expectComplete()
                .verify();
        verify(tourGuideRepo).findAll();
    }

    @Test
    public void findBySkuTest(){
        when(tourGuideRepo.findBySku("key")).thenReturn(Mono.just(tourGuide));
        StepVerifier.create(tourGuideService.findBySku("key"))
                .consumeNextWith(data -> {
                    assertEquals(data,tourGuide);
                })
                .expectComplete()
                .verify();
        verify(tourGuideRepo).findBySku("key");
    }

    @Test
    public void findByNameTest(){
        when(tourGuideRepo.findFirstByName("name")).thenReturn(Mono.just(tourGuide));
        StepVerifier.create(tourGuideService.findByName("name"))
                .consumeNextWith(data -> {
                    assertEquals(data,tourGuide);
                })
                .expectComplete()
                .verify();
        verify(tourGuideRepo).findFirstByName("name");
    }
}
