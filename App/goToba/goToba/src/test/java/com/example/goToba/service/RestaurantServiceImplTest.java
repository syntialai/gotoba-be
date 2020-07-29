package com.example.goToba.service;


import com.example.goToba.model.Restaurant;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.repository.RestaurantRepo;
import com.example.goToba.repository.SequenceRestaurantsRepo;
import com.example.goToba.service.implement.RestaurantServiceImpl;
import com.example.goToba.service.implement.ReviewsServiceImpl;
import com.example.goToba.service.redisService.RestaurantRedisService;
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

import static org.mockito.Mockito.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
@ExtendWith(MockitoExtension.class)
public class RestaurantServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    RestaurantRepo restaurantRepo;

    @Mock
    RestaurantRedisService restaurantRedisService;

    @Mock
    SkuGenerator skuGenerator;

    @Mock
    SequenceRestaurantsRepo sequenceRestaurantsRepo;

    @Mock
    ImageService imageService;

    @InjectMocks
    RestaurantServiceImpl restaurantService;

    private Restaurant restaurant = Restaurant.builder().status(StaticStatus.STATUS_ACTIVE).build();

    @Test
    public void findAllTest() {
        when(restaurantRepo.findAll()).thenReturn(Flux.just(restaurant).filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE)));
        StepVerifier.create(restaurantService.findAll())
                .expectNext(restaurant)
                .expectComplete()
                .verify();
        verify(restaurantRepo).findAll();
    }

    @Test
    public void findBySkuTest(){
        when(restaurantRedisService.hasKey("sku")).thenReturn(false);
        when(restaurantRepo.findBySku("sku")).thenReturn(Mono.just(restaurant));
        StepVerifier.create(restaurantService.findBySku("sku"))
                .expectNext(restaurant)
                .expectComplete()
                .verify();
        verify(restaurantRepo,atLeast(2)).findBySku("sku");
    }
}
