package com.example.goToba.service;

import com.example.goToba.model.Ticket;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.SequenceTicketRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.implement.TicketServiceImpl;
import com.example.goToba.service.utils.RandomGenerator;
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
import reactor.test.StepVerifier;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/07/2020.
 */
@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    TicketRepo ticketRepo;

    @Mock
    OrderDetailRepo orderDetailRepo;

    @Mock
    SkuGenerator skuGenerator;

    @Mock
    SequenceTicketRepo sequenceTicketRepo;

    @Mock
    RandomGenerator randomGenerator;

    @Mock
    ImageService imageService;

    @InjectMocks
    TicketServiceImpl ticketService;

    private Ticket ticket = Ticket.builder().status(StaticStatus.STATUS_ACTIVE).merchantSku("sku").category("category").build();

    @Test
    public void findAllByMerchantSkuTest(){
        when(ticketRepo.findAll()).thenReturn(Flux.just(ticket).filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE)).filter(data -> data.getMerchantSku().equals("sku")));
        StepVerifier.create(ticketService.findAllByMerchantSku("sku"))
                .expectNext(ticket)
                .expectComplete()
                .verify();
        verify(ticketRepo).findAll();
    }

    @Test
    public void findALlTest(){
        when(ticketRepo.findAll()).thenReturn(Flux.just(ticket).filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE)));
        StepVerifier.create(ticketService.findALl())
                .expectNext(ticket)
                .expectComplete()
                .verify();
        verify(ticketRepo).findAll();
    }

    @Test
    public void findAllByCategoryTest(){
        when(ticketRepo.findAll()).thenReturn(Flux.just(ticket).filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE)).filter(data -> data.getCategory().equals("category")));
        StepVerifier.create(ticketService.findAllByCategory("category"))
                .expectNext(ticket)
                .expectComplete()
                .verify();
        verify(ticketRepo).findAll();
    }
}
