package com.example.goToba.service.implement;

import com.example.goToba.model.OrderDetail;
import com.example.goToba.payload.request.OrderDetailRequest;
import com.example.goToba.repository.OrderDetailRepo;
import com.example.goToba.service.OrderDetailService;
import com.example.goToba.service.redisService.OrderDetailRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    OrderDetailRedisService orderDetailRedisService;

    @Override
    public Mono<OrderDetail> findBySku(String sku) {
        return orderDetailRepo.findFirstBySku(sku).map(data -> {
            orderDetailRedisService.add(data);
            return data;
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
        OrderDetail orderDetail =  new OrderDetail(
                (int) UUID.randomUUID().getLeastSignificantBits(),
                UUID.randomUUID().toString(),
                orderDetailRequest.getQuantity(),
                orderDetailRequest.getPrice(),
                orderDetailRequest.getTicketId(),
                orderDetailRequest.getMerchantSku(),
                skuUser
        );
        return orderDetailRepo.save(orderDetail);
    }

    @Override
    public Mono<OrderDetail> editBySkuUser(String sku, OrderDetailRequest orderDetailRequest) {
        return null;
    }
}
