package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceTicket;
import com.example.goToba.model.Ticket;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.payload.request.TicketRequest;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.SequenceTicketRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.utils.RandomGenerator;
import com.example.goToba.service.utils.SkuGenerator;
import com.example.goToba.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.sql.Timestamp;

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

    @Autowired
    RandomGenerator randomGenerator;

    @Autowired
    ImageService imageService;


    @Override
    public Flux<Ticket> findAllByMerchantSku(String sku) {
        return ticketRepo.findAll().filter(data -> data.getMerchantSku().equals(sku));
    }

    @Override
    public Flux<Ticket> findALl() {
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
                            randomGenerator.randInt(),
                            data.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(data.getLast_seq()),
                            ticketRequest.getTitle(),
                            ticketRequest.getDescription(),
                            ticketRequest.getCategory(),
                            ticketRequest.getPrice(),
                            ticketRequest.getDiscount(),
                            ticketRequest.getExpiredDate(),
                            ticketRequest.getMerchantSku(),
                            new Timestamp(System.currentTimeMillis()).toString(),
                            StaticStatus.STATUS_ACTIVE,
                            ticketRequest.getWisataSku(),
                            ticketRequest.getOrderSku(),
                            ImagePath.IMAGE_PATH_TICKET + ImagePath.IMAGE_CONNECTOR + data.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(data.getLast_seq()) + ImagePath.IMAGE_EXTENSION

                    );
                    if (ticketRequest.getImage() != "") {
                        try {
                            imageService.addPicture(ticketRequest.getImage(), ticket.getSku(), ImagePath.IMAGE_PATH_TICKET);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return ticketRepo.save(ticket);
                });

    }

    @Override
    public Mono<Ticket> editBySku(String sku, TicketRequest ticketRequest) {
        return Mono.fromCallable(() -> ticketRequest)
                .flatMap(data -> ticketRepo.findFirstBySku(sku))
                .doOnNext(i -> ticketRepo.deleteBySku(sku).subscribe())
                .flatMap(data -> {
                    Ticket ticket = new Ticket(
                            data.getId(),
                            sku,
                            ticketRequest.getTitle(),
                            ticketRequest.getDescription(),
                            ticketRequest.getCategory(),
                            ticketRequest.getPrice(),
                            ticketRequest.getDiscount(),
                            ticketRequest.getExpiredDate(),
                            ticketRequest.getMerchantSku(),
                            data.getCreatedAt(),
                            StaticStatus.STATUS_ACTIVE,
                            ticketRequest.getWisataSku(),
                            ticketRequest.getOrderSku(),
                            data.getImage()
                    );
                    if (ticketRequest.getImage() != "") {
                        try {
                            imageService.addPicture(ticketRequest.getImage(), ticket.getSku(), ImagePath.IMAGE_PATH_TICKET);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return ticketRepo.save(ticket);
                });

    }

    @Override
    public Mono<Ticket> deleteBySku(String sku) {
        return ticketRepo.findFirstBySku(sku)
                .flatMap(data -> ticketRepo.findFirstBySku(sku))
                .doOnNext(i -> ticketRepo.deleteBySku(sku).subscribe())
                .flatMap(data -> {
                    Ticket ticket = new Ticket(
                            data.getId(),
                            sku,
                            data.getTitle(),
                            data.getDescription(),
                            data.getCategory(),
                            data.getPrice(),
                            data.getDiscount(),
                            data.getExpiredDate(),
                            data.getMerchantSku(),
                            data.getCreatedAt(),
                            StaticStatus.STATUS_ACTIVE,
                            data.getWisataSku(),
                            data.getOrderSku(),
                            data.getImage()
                    );
                    return ticketRepo.save(ticket);
                });

    }
}
