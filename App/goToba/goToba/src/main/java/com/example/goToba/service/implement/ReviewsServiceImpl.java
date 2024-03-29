package com.example.goToba.service.implement;

import com.example.goToba.model.Restaurant;
import com.example.goToba.model.Reviews;
import com.example.goToba.payload.request.ReviewRequest;
import com.example.goToba.repository.RestaurantRepo;
import com.example.goToba.repository.ReviewsRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.ReviewsService;
import com.example.goToba.service.utils.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    ReviewsRepo reviewsRepo;

    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    WisataRepo wisataRepo;

    @Autowired
    RandomGenerator randomGenerator;

    @Override
    public Flux<Reviews> findAllBySkuWisataOrRestaurants(String sku) {
        String skuMerchant;
        if (reviewsRepo.existsByMerchantSku(findSkuMerchantByRestaurant(sku).toString())) {
            return reviewsRepo.findAllByMerchantSku(findSkuMerchantByRestaurant(sku).toString());
        }
        return reviewsRepo.findAllByMerchantSku(findSkuMerchantByWisata(sku).toString());
    }


    @Override
    public Mono<Reviews> addReviewWisata(String sku, String userSku, ReviewRequest reviewRequest) {
        return wisataRepo.findFirstBySku(sku).flatMap(data -> {
            Reviews reviews = new Reviews(
                    randomGenerator.randInt(),
                    sku,
                    reviewRequest.getRating(),
                    reviewRequest.getComment(),
                    data.getCreatedBy(),
                    userSku
            );
            return reviewsRepo.save(reviews);
        });
    }

    @Override
    public Mono<Reviews> addReviewRestaurants(String sku, String userSku, ReviewRequest reviewRequest) {
        return restaurantRepo.findBySku(sku).flatMap(data -> {
            Reviews reviews = new Reviews(
                    randomGenerator.randInt(),
                    sku,
                    reviewRequest.getRating(),
                    reviewRequest.getComment(),
                    data.getMerchantSku(),
                    userSku
            );
            return reviewsRepo.save(reviews);
        });
    }

    public Mono<String> findSkuMerchantByWisata(String sku) {
        return wisataRepo.findFirstBySku(sku).map(data -> {
            return data.getCreatedBy().toString();
        });
    }

    public Mono<String> findSkuMerchantByRestaurant(String sku) {
        return restaurantRepo.findBySku(sku).map(data -> {
            return data.getMerchantSku().toString();
        });
    }

}
