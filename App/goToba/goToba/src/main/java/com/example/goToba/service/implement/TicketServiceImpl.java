package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceTicket;
import com.example.goToba.model.Ticket;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.helper.Strings;
import com.example.goToba.payload.request.TicketRequest;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.SequenceTicketRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.SkuGenerator;
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

    @Autowired
    SkuGenerator skuGenerator;

    @Autowired
    SequenceTicketRepo sequenceTicketRepo;


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
    public Mono<List<Ticket>> findBySkuUser(String skuUser) {
        return orderDetailRepo.findAll()
                .filter(data -> data.getUserSku().equals(skuUser))
                .collectList()
                .map(data -> {
                    List<Ticket> ticketList = new ArrayList<>();
                    for (int i = 0; i < data.size(); i++) {
                        System.out.println("test");
                        int finalI = i;
                        ticketRepo.findAll()
                                .filter(dataTicket -> dataTicket.getOrderId().equals(data.get(finalI).getId()))
                                .collectList()
                                .doOnNext(datas -> System.out.println(datas))
                                .map(result ->ticketList.add((Ticket) result));
                    }
                    return ticketList;
                });
    }

    @Override
    public Mono<Ticket> addByMerchantSku(String merchantSku, TicketRequest ticketRequest) {
        String key = skuGenerator.substring(StockKeepingUnit.TICKET + StockKeepingUnit.SKU_CONNECTOR + skuGenerator.substring(ticketRequest.getCategory()));
        return Mono.fromCallable(() -> ticketRequest)
                .flatMap(dat -> sequenceTicketRepo.findFirstByKey(key))
                .doOnNext(dat -> sequenceTicketRepo.deleteByKey(key).subscribe())
                .doOnNext(dat -> sequenceTicketRepo.save(new SequenceTicket(key, StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(dat.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceTicketRepo.save(new SequenceTicket(key, StockKeepingUnit.SKU_DATA_BEGINNING + "1")))
                .flatMap(dat -> sequenceTicketRepo.findFirstByKey(key))
                .flatMap(data -> {
                    Ticket ticket = new Ticket(
                            (int) UUID.randomUUID().getLeastSignificantBits(),
                            data.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(data.getLast_seq()),
                            ticketRequest.getCategory(),
                            ticketRequest.getPrice(),
                            ticketRequest.getExpiredDate(),
                            ticketRequest.getMerchantSku(),
                            new Timestamp(System.currentTimeMillis()).toString(),
                            Strings.STATUS_ACTIVE,
                            ticketRequest.getWisataSku(),
                            ticketRequest.getOrderId()
                    );
                    return ticketRepo.save(ticket);
                });

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
                            data.getStatus(),
                            ticketRequest.getWisataSku(),
                            ticketRequest.getOrderId()
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
                            Strings.STATUS_DELETE,
                            data.getWisataSku(),
                            data.getOrderId()
                    );
                    return ticketRepo.save(ticket);
                });

    }
}
