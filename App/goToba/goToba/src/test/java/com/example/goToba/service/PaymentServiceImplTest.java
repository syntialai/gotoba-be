package com.example.goToba.service;

import com.example.goToba.model.Payment;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.repository.PaymentRepo;
import com.example.goToba.repository.SequencePaymentRepo;
import com.example.goToba.service.implement.PaymentServiceImpl;
import com.example.goToba.service.utils.SkuGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
public class PaymentServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    PaymentRepo paymentRepo;

    @Mock
    SkuGenerator skuGenerator;

    @Mock
    SequencePaymentRepo sequencePaymentRepo;

    @InjectMocks
    PaymentServiceImpl paymentService;
    private Payment payment = new Payment();

    @Test
    public void findAllTest() {
        when(paymentRepo.findAll()).thenReturn(Flux.just(payment));
        StepVerifier.create(paymentService.findAll())
                .expectNext(payment)
                .expectComplete()
                .verify();
        verify(paymentRepo).findAll();
    }

    @Test
    public void findBySkuTest() {
        when(paymentRepo.findFirstBySku("sku")).thenReturn(Mono.just(payment));
        StepVerifier.create(paymentService.findBySku("sku"))
                .expectNext(payment)
                .expectComplete()
                .verify();
        verify(paymentRepo).findFirstBySku("sku");
    }
}
