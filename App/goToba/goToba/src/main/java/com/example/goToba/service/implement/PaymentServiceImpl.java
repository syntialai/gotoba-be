package com.example.goToba.service.implement;

import com.example.goToba.model.Payment;
import com.example.goToba.repository.PaymentRepo;
import com.example.goToba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/06/2020.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;


}
