package com.example.goToba.service;

import com.example.goToba.model.Reviews;
import com.example.goToba.payload.request.ReviewRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
public interface ReviewsService {

    Flux<Reviews> findAllBySkuWisataOrRestaurants(String sku);
    void addReviewBySku(String sku, String userSku, ReviewRequest reviewRequest);
}
