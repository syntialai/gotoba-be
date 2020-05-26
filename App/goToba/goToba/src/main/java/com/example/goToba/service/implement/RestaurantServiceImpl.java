package com.example.goToba.service.implement;

import com.example.goToba.model.MenuRestaurants;
import com.example.goToba.model.Restaurant;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import com.example.goToba.payload.request.RestaurantsRequest;
import com.example.goToba.repository.MenuRestaurantsRepo;
import com.example.goToba.repository.RestaurantRepo;
import com.example.goToba.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    MenuRestaurantsRepo menuRestaurantsRepo;


    @Override
    public Mono<Restaurant> findBySku(String sku) {
        return restaurantRepo.findBySku(sku);
    }

    @Override
    public Mono<Restaurant> addRestaurant(RestaurantsRequest restaurantsRequest, String sku) {
        Restaurant restaurant = new Restaurant(
                UUID.randomUUID().toString(),
                restaurantsRequest.getName(),
                restaurantsRequest.getBistroType(),
                restaurantsRequest.getLocation(),
                5.0,
                restaurantsRequest.getAddress(),
                restaurantsRequest.getHoursOpen(),
                restaurantsRequest.getPhone(),
                "active",
                sku
        );
        return restaurantRepo.save(restaurant);
    }

    @Override
    public Mono<MenuRestaurants> addRestaurantMenu(MenuRestaurantsRequest menuRestaurantsRequest) {
        MenuRestaurants menuRestaurants= new MenuRestaurants(
                Integer.parseInt(UUID.randomUUID().toString()),
                menuRestaurantsRequest.getName(),
                menuRestaurantsRequest.getPicture(),
                menuRestaurantsRequest.getCategory(),
                menuRestaurantsRequest.getHarga(),
                "1",
                menuRestaurantsRequest.getRestoranSku(),
                menuRestaurantsRequest.getMerchantSku()
        );
        return menuRestaurantsRepo.save(menuRestaurants);
    }

    @Override
    public Mono<MenuRestaurants> editRestaurantMenu(Integer idMenu,MenuRestaurantsRequest menuRestaurantsRequest) {
        return Mono.fromCallable(() -> menuRestaurantsRequest)
                .doOnNext(i -> {
                    menuRestaurantsRepo.deleteById(idMenu).subscribe();
                })
                .flatMap(data ->{
                    MenuRestaurants menuRestaurants= new MenuRestaurants(
                            Integer.parseInt(UUID.randomUUID().toString()),
                            menuRestaurantsRequest.getName(),
                            menuRestaurantsRequest.getPicture(),
                            menuRestaurantsRequest.getCategory(),
                            menuRestaurantsRequest.getHarga(),
                            "1",
                            menuRestaurantsRequest.getRestoranSku(),
                            menuRestaurantsRequest.getMerchantSku()
                    );
                    return menuRestaurantsRepo.save(menuRestaurants);
                });
    }
}
