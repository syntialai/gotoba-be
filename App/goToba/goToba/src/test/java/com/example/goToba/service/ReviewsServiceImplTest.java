package com.example.goToba.service;

import com.example.goToba.model.Restaurant;
import com.example.goToba.model.Reviews;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.repository.RestaurantRepo;
import com.example.goToba.repository.ReviewsRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.implement.ReviewsServiceImpl;
import com.example.goToba.service.implement.TicketServiceImpl;
import com.example.goToba.service.utils.RandomGenerator;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
@ExtendWith(MockitoExtension.class)
public class ReviewsServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    ReviewsRepo reviewsRepo;

    @Mock
    RestaurantRepo restaurantRepo;

    @Mock
    WisataRepo wisataRepo;

    @Mock
    RandomGenerator randomGenerator;

    @InjectMocks
    ReviewsServiceImpl reviewsService;

    private Reviews reviews = new Reviews();
    private Restaurant restaurant = Restaurant.builder().status(StaticStatus.STATUS_ACTIVE).merchantSku("sku").build();
    private Wisata wisata = Wisata.builder().createdBy("sku").build();
    @Test
    public void findAllBySkuWisataOrRestaurantsTest() {
        when(reviewsRepo.existsByMerchantSku("sku")).thenReturn(true);
        when(wisataRepo.findFirstBySku("sku")).thenReturn(Mono.just(wisata));
        when(reviewsService.findSkuMerchantByWisata("sku")).thenReturn(Mono.just("sku"));
        when(restaurantRepo.findBySku("sku")).thenReturn(Mono.just(restaurant));
        when(reviewsRepo.findAllByMerchantSku("sku")).thenReturn(Flux.just(reviews));
        when(reviewsService.findAllBySkuWisataOrRestaurants ("sku")).thenReturn(Flux.just(reviews));
        System.out.println(reviewsService.findAllBySkuWisataOrRestaurants("sku"));
        StepVerifier.create(reviewsService.findAllBySkuWisataOrRestaurants("sku"))
                .expectNext(reviews)
                .expectComplete()
                .verify();
//        verify(reviewsRepo).findAllByMerchantSku("sku");
    }

    @Test
    public void findSkuMerchantByWisataTest(){
        when(wisataRepo.findFirstBySku("sku")).thenReturn(Mono.just(wisata));
        StepVerifier.create(reviewsService.findSkuMerchantByWisata("sku"))
                .expectNext(wisata.getCreatedBy())
                .expectComplete()
                .verify();
        verify(wisataRepo).findFirstBySku("sku");
    }

    @Test
    public void findSkuMerchantByRestaurant(){
        when(restaurantRepo.findBySku("sku")).thenReturn(Mono.just(restaurant));
        StepVerifier.create(reviewsService.findSkuMerchantByRestaurant("sku"))
                .expectNext(restaurant.getMerchantSku())
                .expectComplete()
                .verify();
        verify(restaurantRepo).findBySku("sku");
    }
}
