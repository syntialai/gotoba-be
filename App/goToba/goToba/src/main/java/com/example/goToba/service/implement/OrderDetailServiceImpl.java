package com.example.goToba.service.implement;

import com.example.goToba.model.OrderDetail;
import com.example.goToba.model.SequenceOrder;
import com.example.goToba.payload.helper.*;
import com.example.goToba.payload.request.OrderDetailRequest;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.SequenceOrderRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.OrderDetailService;
import com.example.goToba.service.utils.SkuGenerator;
import com.example.goToba.service.redisService.OrderDetailRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    OrderDetailRedisService orderDetailRedisService;

    @Autowired
    SkuGenerator skuGenerator;

    @Autowired
    SequenceOrderRepo sequenceOrderRepo;

    @Autowired
    TicketRepo ticketRepo;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Override
    public Mono<OrderDetail> findBySku(String sku) {
        if (orderDetailRedisService.hasKey(sku)) {
            return orderDetailRedisService.findById(sku);
        }
        return orderDetailRepo.findFirstBySku(sku);
    }

    @Override
    public Mono<OrderDetail> findFirstBySku(String sku) {
        return orderDetailRepo.findFirstBySku(sku);
    }

    @Override
    public Mono<OrderDetail> checkOut(String sku) {
        return Mono.fromCallable(() -> sku)
                .flatMap(data -> orderDetailRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    orderDetailRepo.deleteBySku(sku).subscribe();
                    orderDetailRedisService.delete(sku);
                })
                .flatMap(data -> {
                    data.setRedeem(false);
                    data.setStatus(StaticStatus.STATUS_CHECKOUT);
                    orderDetailRedisService.add(data);
                    return orderDetailRepo.save(data);
                });
    }

    @Override
    public Mono<OrderDetail> redeemed(String sku) {
        return Mono.fromCallable(() -> sku)
                .flatMap(data -> orderDetailRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    orderDetailRepo.deleteBySku(sku).subscribe();
                    orderDetailRedisService.delete(sku);
                })
                .flatMap(data -> {
                    data.setRedeem(false);
                    orderDetailRedisService.add(data);
                    return orderDetailRepo.save(data);
                });
    }


    @Override
    public Mono<OrderDetail> approval(String sku, Integer status) {
        return Mono.fromCallable(() -> sku)
                .flatMap(data -> orderDetailRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    orderDetailRepo.deleteBySku(sku).subscribe();
                    orderDetailRedisService.delete(sku);
                })
                .flatMap(data -> {
                    data.setStatus(status);
                    data.setRedeem(false);
                    if(status == StaticStatus.STATUS_APPROVE){
                        data.setRedeem(true);
                    }
                    orderDetailRedisService.add(data);
                    return orderDetailRepo.save(data);
                });
    }

    @Override
    public Mono<OrderDetail> cancelOrDelete(String sku) {
        return Mono.fromCallable(() -> sku)
                .flatMap(data -> orderDetailRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    orderDetailRepo.deleteBySku(sku).subscribe();
                    orderDetailRedisService.delete(sku);
                })
                .flatMap(data -> {
                    data.setStatus(StaticStatus.STATUS_CANCEL_REJECT_OR_DELETE);
                    orderDetailRedisService.add(data);
                    return orderDetailRepo.save(data);
                });
    }

    @Override
    public Mono<OrderDetail> findFirstBySkuUser(String skuUser) {
        return orderDetailRepo.findFirstByUserSku(skuUser);
    }


    @Override
    public Flux<OrderDetail> findAll() {
        return orderDetailRepo.findAll();
    }


    @Override
    public Mono<OrderDetail> addBySkuUser(String skuUser, OrderDetailRequest orderDetailRequest) {
        String key = StockKeepingUnit.ORDER + StockKeepingUnit.SKU_CONNECTOR + skuGenerator.substring(orderDetailRequest.getUserSku());
        return Mono.fromCallable(() -> orderDetailRequest)
                .flatMap(i -> sequenceOrderRepo.findFirstByKey(key))
                .doOnNext(i -> sequenceOrderRepo.deleteByKey(key).subscribe())
                .doOnNext(i -> sequenceOrderRepo.save(new SequenceOrder(key, StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(i.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceOrderRepo.save(new SequenceOrder(key, StockKeepingUnit.SKU_FIRST_DATA)))
                .flatMap(i -> sequenceOrderRepo.findFirstByKey(key))
                .flatMap(req -> {
                    OrderDetail orderDetail = new OrderDetail(
                            (int) UUID.randomUUID().getLeastSignificantBits(),
//                            req.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(req.getLast_seq())),
                            UUID.randomUUID().toString(),
                            orderDetailRequest.getTicketSku(),
                            orderDetailRequest.getQuantity(),
                            orderDetailRequest.getPrice(),
                            orderDetailRequest.getDiscount(),
                            orderDetailRequest.getMerchantSku(),
                            orderDetailRequest.getCategory(),
                            orderDetailRequest.getWisataSku(),
                            orderDetailRequest.getImage(),
                            skuUser,
                            StaticStatus.STATUS_CART,
                            false,
                            orderDetailRequest.getExpiredDate(),
                            orderDetailRequest.getTitle()
                    );
                    GregorianCalendar gc = new GregorianCalendar();
                    gc.add(Calendar.DATE, 1);
                    Integer dayat = gc.get(Calendar.DAY_OF_MONTH) + 7;
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    return orderDetailRepo.save(orderDetail);
                });
    }

    @Override
    public Mono<OrderDetail> editBySku(String sku, OrderDetailRequest orderDetailRequest) {
        return Mono.fromCallable(() -> orderDetailRequest)
                .flatMap(data -> orderDetailRepo.findFirstBySku(sku))
                .doOnNext(i -> {
                    orderDetailRepo.deleteBySku(sku).subscribe();
                    orderDetailRedisService.delete(sku);
                })
                .flatMap(data -> {
                    OrderDetail orderDetail = new OrderDetail(
                            data.getId(),
                            sku,
                            orderDetailRequest.getTicketSku(),
                            orderDetailRequest.getQuantity(),
                            orderDetailRequest.getPrice(),
                            orderDetailRequest.getDiscount(),
                            orderDetailRequest.getMerchantSku(),
                            orderDetailRequest.getCategory(),
                            orderDetailRequest.getWisataSku(),
                            orderDetailRequest.getImage(),
                            data.getUserSku(),
                            data.getStatus(),
                            data.getRedeem(),
                            orderDetailRequest.getExpiredDate(),
                            orderDetailRequest.getTitle()
                    );
                    orderDetailRedisService.add(orderDetail);
                    return orderDetailRepo.save(orderDetail);
                });
    }

    @Override
    public Mono<Boolean> deleteBySku(String sku) {
        orderDetailRedisService.delete(sku);
        return orderDetailRepo.deleteBySku(sku);
    }

}
