package com.example.goToba.service.implement;

import com.example.goToba.controller.route.OrderDetailControllerRoute;
import com.example.goToba.model.OrderDetail;
import com.example.goToba.model.SequenceOrder;
import com.example.goToba.model.Ticket;
import com.example.goToba.payload.NotFoundResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.helper.*;
import com.example.goToba.payload.request.OrderDetailRequest;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.repository.SequenceOrderRepo;
import com.example.goToba.repository.TicketRepo;
import com.example.goToba.service.OrderDetailService;
import com.example.goToba.service.SkuGenerator;
import com.example.goToba.service.redisService.OrderDetailRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Mono<ResponseEntity<?>> findBySku(String sku) {
        return orderDetailRepo.findFirstBySku(sku).map((data) -> {
            if (data.getUserSku() != null) {
                orderDetailRedisService.add(data);
                return ResponseEntity.status(HttpStatus.OK).body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new NotFoundResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_UNAUTHORIZED, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "order with sku " + sku + ".", OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU));
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.OK).body(new NotFoundResponse(timestamp.toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "order with sku " + sku + ".", OrderDetailControllerRoute.ROUTE_ORDER + OrderDetailControllerRoute.ROUTE_ORDER_DETAIL_BY_SKU)));
    }

    @Override
    public Mono<OrderDetail> findFirstBySku(String sku) {
        return orderDetailRepo.findFirstBySku(sku);
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
                            req.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(req.getLast_seq())),
                            orderDetailRequest.getTicket(),
                            skuUser,
                            Strings.STATUS_ACTIVE
                    );
                    GregorianCalendar gc = new GregorianCalendar();
                    gc.add(Calendar.DATE, 1);
                    Integer dayat = gc.get(Calendar.DAY_OF_MONTH) + 7;
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    for (int i = 0; i < orderDetailRequest.getTicket().size(); i++) {
                        Ticket ticket = new Ticket(
                                (int) UUID.randomUUID().getLeastSignificantBits(),
                                UUID.randomUUID().toString(),
                                orderDetailRequest.getTicket().get(i).getCategory(),
                                orderDetailRequest.getTicket().get(i).getPrice(),
                                dayat.toString(),
                                orderDetailRequest.getTicket().get(i).getMerchantSku(),
                                dtf.format(now).toString(),
                                Strings.STATUS_ACTIVE,
                                orderDetailRequest.getTicket().get(i).getWisataSku(),
                                orderDetail.getId(),
                                skuUser
                        );
                        ticketRepo.save(ticket).subscribe();
                    }
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
                            orderDetailRequest.getTicket(),
                            data.getUserSku(),
                            data.getStatus()
                    );
                    orderDetailRedisService.add(orderDetail);
                    return orderDetailRepo.save(orderDetail);
                });
    }

    @Override
    public Mono<OrderDetail> deleteBySku(String sku) {
        return orderDetailRepo.findFirstBySku(sku)
                .doOnNext(i -> {
                    orderDetailRepo.deleteBySku(sku).subscribe();
                    orderDetailRedisService.delete(sku);
                })
                .flatMap(data -> {
                    OrderDetail orderDetail = new OrderDetail(
                            data.getId(),
                            sku,
                            data.getTicket(),
                            data.getUserSku(),
                            Strings.STATUS_DELETE
                    );
                    orderDetailRedisService.add(orderDetail);
                    return orderDetailRepo.save(orderDetail);
                });
    }
}
