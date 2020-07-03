package com.example.goToba.service.implement;

import com.example.goToba.model.Payment;
import com.example.goToba.model.SequencePayment;
import com.example.goToba.payload.PaymentUpdateRequest;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.request.PaymentRequest;
import com.example.goToba.repository.PaymentRepo;
import com.example.goToba.repository.SequencePaymentRepo;
import com.example.goToba.service.PaymentService;
import com.example.goToba.service.utils.SkuGenerator;
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

    @Autowired
    SkuGenerator skuGenerator;

    @Autowired
    SequencePaymentRepo sequencePaymentRepo;

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
        String key = StockKeepingUnit.PAYMENT + StockKeepingUnit.SKU_CONNECTOR + skuGenerator.substring(paymentRequest.getMerchantSku());
        return Mono.fromCallable(() -> paymentRequest)
                .flatMap(i -> sequencePaymentRepo.findFirstByKey(key))
                .doOnNext(i -> sequencePaymentRepo.deleteByKey(key).subscribe())
                .doOnNext(i -> sequencePaymentRepo.save(new SequencePayment(key, StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(i.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequencePaymentRepo.save(new SequencePayment(key, StockKeepingUnit.SKU_FIRST_DATA)))
                .flatMap(i -> sequencePaymentRepo.findFirstByKey(key))
                .flatMap(req -> {
                    Payment payment = new Payment(
                            (int) UUID.randomUUID().getLeastSignificantBits(),
                            req.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(req.getLast_seq())),
                            paymentRequest.getTotal(),
                            paymentRequest.getStatus(),
                            paymentRequest.getOrderId(),
                            paymentRequest.getMerchantSku(),
                            sku
                    );
                    return paymentRepo.save(payment);
                });
    }

    @Override
    public Mono<Payment> findFirstBySkuUser(String sku) {
        return paymentRepo.findFirstByUserSku(sku);
    }

    @Override
    public Mono<Payment> editBySku(String sku, PaymentUpdateRequest paymentUpdateRequest) {
        return Mono.fromCallable(() -> paymentUpdateRequest).
                flatMap(data -> paymentRepo.findFirstBySku(sku)).
                doOnNext( i -> {
                    paymentRepo.deleteBySku(sku).subscribe();
                }).
                flatMap(data -> {
                    Payment payment = new Payment(
                            (int) UUID.randomUUID().getLeastSignificantBits(),
                            sku,
                            paymentUpdateRequest.getTotal(),
                            paymentUpdateRequest.getStatus(),
                            paymentUpdateRequest.getOrderId(),
                            data.getMerchantSku(),
                            data.getUserSku()
                    );
                    return paymentRepo.save(payment);
                });
    }


}
