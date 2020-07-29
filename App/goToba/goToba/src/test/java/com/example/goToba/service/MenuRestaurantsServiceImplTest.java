package com.example.goToba.service;

import com.example.goToba.model.MenuRestaurants;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.repository.MenuRestaurantsRepo;
import com.example.goToba.service.implement.MenuRestaurantsServiceImpl;
import com.example.goToba.service.utils.RandomGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
@ExtendWith(MockitoExtension.class)
public class MenuRestaurantsServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    MenuRestaurantsRepo menuRestaurantsRepo;

    @Mock
    ImageService imageService;

    @Mock
    RandomGenerator randomGenerator;

    @InjectMocks
    MenuRestaurantsServiceImpl menuRestaurantsService;

    private MenuRestaurants menuRestaurants =  MenuRestaurants.builder().status(StaticStatus.STATUS_ACTIVE).build();
    @Test
    public void findByIdMenuTest(){
        when(menuRestaurantsRepo.findById(1)).thenReturn(Mono.just(menuRestaurants));
        StepVerifier.create(menuRestaurantsService.findByIdMenu(1).filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE)))
                .expectNext(menuRestaurants)
                .expectComplete()
                .verify();
        verify(menuRestaurantsRepo).findById(1);
    }
}
