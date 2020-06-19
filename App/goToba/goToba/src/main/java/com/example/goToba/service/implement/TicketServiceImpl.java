package com.example.goToba.service.implement;

import com.example.goToba.model.Ticket;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Override
    public Flux<Ticket> findAllByMerchantSku(String sku) {
        return ticketRepo.findAll().filter(data -> data.getMerchantSku().equals(sku));
    }

    @Override
    public Flux<Ticket> findALl(String sku) {
        return ticketRepo.findAll();
    }

    @Override
    public Flux<Ticket> findAllByCategory(String category) {
        return ticketRepo.findAll().filter(data -> data.getCategory().equals(category));
    }

    @Override
    public Mono<Ticket> findBySku(String sku) {
        return ticketRepo.findFirstBySku(sku);
    }

    @Override
    public Flux<Ticket> findBySkuUser(String skuUser) {
        return null;
//        List<Ticket> list = new ArrayList<>();
//        return orderDetailRepo.findAllByUserSku(skuUser).collectList().
//                flatMapIterable(data -> {
//                    for(int i=0 ; i<data.size() ; i++){
//                        Ticket ticket= new Ticket(
//                                data.get(i).getId(),
//                                data.get(i).getSku(),
//                                data.get(i).ge(),
//
//                        );
//                        list.add(ticket);
//                    }
//                    return list;
//                });
    }
}
