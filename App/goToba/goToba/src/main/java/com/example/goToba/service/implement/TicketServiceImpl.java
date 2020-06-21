package com.example.goToba.service.implement;

import com.example.goToba.model.Ticket;
import com.example.goToba.payload.request.TicketRequest;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public Mono<Ticket> addByMerchantSku(String merchantSku, TicketRequest ticketRequest) {
        Ticket ticket = new Ticket(
                (int) UUID.randomUUID().getLeastSignificantBits(),
                UUID.randomUUID().toString(),
                ticketRequest.getCategory(),
                ticketRequest.getPrice(),
                ticketRequest.getExpiredDate(),
                ticketRequest.getMerchantSku(),
                new Timestamp(System.currentTimeMillis()).toString(),
                "active"
        );
        return ticketRepo.save(ticket);
    }

    @Override
    public Mono<Ticket> editBySku(String sku, TicketRequest ticketRequest) {
        return Mono.fromCallable(() -> ticketRequest)
                .flatMap(data -> ticketRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    ticketRepo.deleteBySku(sku).subscribe();
                })
                .flatMap(data -> {
                    Ticket ticket = new Ticket(
                            data.getId(),
                            sku,
                            ticketRequest.getCategory(),
                            ticketRequest.getPrice(),
                            ticketRequest.getExpiredDate(),
                            ticketRequest.getMerchantSku(),
                            new Timestamp(System.currentTimeMillis()).toString(),
                            data.getStatus()
                    );
                    return ticketRepo.save(ticket);
                });

    }

    @Override
    public Mono<Ticket> deleteBySku(String sku) {
        return ticketRepo.findFirstBySku(sku)
                .flatMap(data -> ticketRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    ticketRepo.deleteBySku(sku).subscribe();
                })
                .flatMap(data -> {
                    Ticket ticket = new Ticket(
                            data.getId(),
                            sku,
                            data.getCategory(),
                            data.getPrice(),
                            data.getExpiredDate(),
                            data.getMerchantSku(),
                            new Timestamp(System.currentTimeMillis()).toString(),
                            "deleted"
                    );
                    return ticketRepo.save(ticket);
                });

    }
}
