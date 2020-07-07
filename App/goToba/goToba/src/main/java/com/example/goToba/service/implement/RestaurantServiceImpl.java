package com.example.goToba.service.implement;

import com.example.goToba.model.*;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.helper.Strings;
import com.example.goToba.payload.request.RestaurantsRequest;
import com.example.goToba.repository.RestaurantRepo;
import com.example.goToba.repository.SequenceRestaurantsRepo;
import com.example.goToba.service.RestaurantService;
import com.example.goToba.service.utils.SkuGenerator;
import com.example.goToba.service.redisService.RestaurantRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;


    @Autowired
    RestaurantRedisService restaurantRedisService;

    @Autowired
    SkuGenerator skuGenerator;

    @Autowired
    SequenceRestaurantsRepo sequenceRestaurantsRepo;

    @Override
    public Flux<Restaurant> findAll() {
        return restaurantRepo.findAll();
    }

    @Override
    public Mono<Restaurant> findBySku(String sku) {
        return restaurantRepo.findBySku(sku).
                doOnNext(data -> restaurantRedisService.add(data)).
                flatMap(data -> {
                    return restaurantRepo.findBySku(sku);
                });
    }

    @Override
    public Mono<Restaurant> addRestaurant(RestaurantsRequest restaurantsRequest, String sku) {
        String key = skuGenerator.substring(restaurantsRequest.getName());
        return Mono.fromCallable(() -> restaurantsRequest)
                .flatMap(i -> sequenceRestaurantsRepo.findFirstByKey(key))
                .doOnNext(i -> sequenceRestaurantsRepo.deleteByKey(key).subscribe())
                .doOnNext(i -> sequenceRestaurantsRepo.save(new SequenceRestaurants(key, StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(i.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceRestaurantsRepo.save(new SequenceRestaurants(key, StockKeepingUnit.SKU_FIRST_DATA)))
                .flatMap(i -> sequenceRestaurantsRepo.findFirstByKey(key))
                .flatMap(req -> {
                    Restaurant restaurant = new Restaurant(
                            StockKeepingUnit.RESTAURANTS + StockKeepingUnit.SKU_CONNECTOR + req.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(req.getLast_seq())),
                            restaurantsRequest.getName(),
                            restaurantsRequest.getBistroType(),
                            restaurantsRequest.getLongitude(),
                            restaurantsRequest.getLatitude(),
                            5.0,
                            restaurantsRequest.getAddress(),
                            restaurantsRequest.getHoursOpen(),
                            restaurantsRequest.getPhone(),
                            Strings.STATUS_ACTIVE,
                            sku
                    );
                    return restaurantRepo.save(restaurant);
                });
    }

    @Override
    public Mono<Restaurant> editRestaurant(RestaurantsRequest restaurantsRequest, String sku) {
        return Mono.fromCallable(() -> restaurantsRequest)
                .flatMap(data -> restaurantRepo.findBySku(sku))
                .doOnNext(i -> {
                    restaurantRepo.deleteBySku(sku).subscribe();
                    restaurantRedisService.delete(sku);
                })
                .flatMap(data -> {
                    Restaurant restaurant = new Restaurant(
                            sku,
                            restaurantsRequest.getName(),
                            restaurantsRequest.getBistroType(),
                            restaurantsRequest.getLongitude(),
                            restaurantsRequest.getLatitude(),
                            data.getRating(),
                            restaurantsRequest.getAddress(),
                            restaurantsRequest.getHoursOpen(),
                            restaurantsRequest.getPhone(),
                            Strings.STATUS_ACTIVE,
                            data.getMerchantSku()
                    );
                    restaurantRedisService.add(restaurant);
                    return restaurantRepo.save(restaurant);
                });
    }


}
