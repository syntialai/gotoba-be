package com.example.goToba.service.implement;

import com.example.goToba.model.Ticket;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepo ticketRepo;

    @Override
    public Flux<Ticket> findAllByMerchantSku(String sku) {
        return ticketRepo.findAll().filter(data -> data.getMerchantSku().equals(sku));
    }

    @Override
    public Flux<Ticket> findALl(String sku) {
        return ticketRepo.findAll();
    }
}
