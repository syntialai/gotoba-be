package com.example.goToba.service.implement;

import com.example.goToba.model.Payment;
import com.example.goToba.payload.request.PaymentRequest;
import com.example.goToba.repository.PaymentRepo;
import com.example.goToba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/06/2020.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;


    @Override
    public Flux<Payment> findAll() {
        return paymentRepo.findAll();
    }

    @Override
    public Mono<Payment> findBySku(String sku) {
        return paymentRepo.findFirstBySku(sku);
    }

    @Override
    public Mono<Payment> addByUserSku(String sku, PaymentRequest paymentRequest) {
        Payment payment = new Payment(
                (int) UUID.randomUUID().getLeastSignificantBits(),
                UUID.randomUUID().toString(),
                paymentRequest.getCategory(),
                paymentRequest.getTotal(),
                paymentRequest.getStatus(),
                paymentRequest.getOrderId(),
                sku,
                sku
        );
        return paymentRepo.save(payment);
    }

    @Override
    public Mono<Payment> findFirstBySkuUser(String sku) {
        return paymentRepo.findFirstByUserSku(sku);
    }

    @Override
    public Mono<Payment> editBySku(String sku, PaymentRequest paymentRequest) {
        return Mono.fromCallable(() -> paymentRequest).
                flatMap(data -> paymentRepo.findFirstBySku(sku)).
                doOnNext( i -> {
                    paymentRepo.deleteBySku(sku).subscribe();
                }).
                flatMap(data -> {
                    Payment payment = new Payment(
                            (int) UUID.randomUUID().getLeastSignificantBits(),
                            sku,
                            paymentRequest.getCategory(),
                            paymentRequest.getTotal(),
                            paymentRequest.getStatus(),
                            paymentRequest.getOrderId(),
                            paymentRequest.getMerchantSku(),
                            data.getUserSku()
                    );
                    return paymentRepo.save(payment);
                });
    }


}
