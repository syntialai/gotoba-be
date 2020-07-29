package com.example.goToba.service;

import com.example.goToba.model.OrderDetail;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.SequenceOrderRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.implement.OrderDetailServiceImpl;
import com.example.goToba.service.redisService.OrderDetailRedisService;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
@ExtendWith(MockitoExtension.class)
public class OrderDetailServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    OrderDetailRepo orderDetailRepo;

    @Mock
    OrderDetailRedisService orderDetailRedisService;

    @Mock
    SkuGenerator skuGenerator;

    @Mock
    SequenceOrderRepo sequenceOrderRepo;

    @Mock
    TicketRepo ticketRepo;

    @InjectMocks
    OrderDetailServiceImpl orderDetailService;

    private OrderDetail orderDetail = new OrderDetail();

    @Test
    public void findBySkuTest(){
        when(orderDetailRedisService.hasKey("sku")).thenReturn(false);
        when(orderDetailRepo.findFirstBySku("sku")).thenReturn(Mono.just(orderDetail));
        StepVerifier.create(orderDetailService.findBySku("sku"))
                .expectNext(orderDetail)
                .expectComplete()
                .verify();
        verify(orderDetailRepo).findFirstBySku("sku");
    }

    @Test
    public void findFirstBySkuTest(){
        when(orderDetailRepo.findFirstBySku("sku")).thenReturn(Mono.just(orderDetail));
        StepVerifier.create(orderDetailService.findFirstBySku("sku"))
                .expectNext(orderDetail)
                .expectComplete()
                .verify();
        verify(orderDetailRepo).findFirstBySku("sku");
    }

    @Test
    public void findAllTest(){
        when(orderDetailRepo.findAll()).thenReturn(Flux.just(orderDetail));
        StepVerifier.create(orderDetailService.findAll())
                .expectNext(orderDetail)
                .expectComplete()
                .verify();
        verify(orderDetailRepo).findAll();
    }

    @Test
    public void findFirstBySkuUserTest(){
        when(orderDetailRepo.findFirstByUserSku("sku")).thenReturn(Mono.just(orderDetail));
        StepVerifier.create(orderDetailService.findFirstBySkuUser("sku"))
                .expectNext(orderDetail)
                .expectComplete()
                .verify();
        verify(orderDetailRepo).findFirstByUserSku("sku");
    }

}
