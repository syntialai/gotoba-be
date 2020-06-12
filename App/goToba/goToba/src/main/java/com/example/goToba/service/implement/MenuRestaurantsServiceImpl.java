package com.example.goToba.service.implement;

import com.example.goToba.model.MenuRestaurants;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import com.example.goToba.repository.MenuRestaurantsRepo;
import com.example.goToba.service.MenuRestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/06/2020.
 */
@Service
public class MenuRestaurantsServiceImpl implements MenuRestaurantsService {

    @Autowired
    MenuRestaurantsRepo menuRestaurantsRepo;

    @Override
    public Mono<MenuRestaurants> findByIdMenu(Integer idMenu) {
        return menuRestaurantsRepo.findById(idMenu);
    }

    @Override
    public Mono<MenuRestaurants> findByNama(String nama) {
        return menuRestaurantsRepo.findFirstByName(nama);
    }

    @Override
    public Mono<MenuRestaurants> addRestaurantMenu(String sku, MenuRestaurantsRequest menuRestaurantsRequest) {
        MenuRestaurants menuRestaurants = new MenuRestaurants(
                (int) UUID.randomUUID().getLeastSignificantBits(),
                menuRestaurantsRequest.getName(),
                menuRestaurantsRequest.getPicture(),
                menuRestaurantsRequest.getCategory(),
                menuRestaurantsRequest.getHarga(),
                "1",
                sku,
                menuRestaurantsRequest.getMerchantSku()
        );
        return menuRestaurantsRepo.save(menuRestaurants);
    }

    @Override
    public Mono<MenuRestaurants> editRestaurantMenu(String sku, Integer idMenu, MenuRestaurantsRequest menuRestaurantsRequest) {
        return Mono.fromCallable(() -> menuRestaurantsRequest)
                .doOnNext(i -> {
                    menuRestaurantsRepo.deleteById(idMenu).subscribe();
                })
                .flatMap(data -> {
                    MenuRestaurants menuRestaurants = new MenuRestaurants(
                            idMenu,
                            menuRestaurantsRequest.getName(),
                            menuRestaurantsRequest.getPicture(),
                            menuRestaurantsRequest.getCategory(),
                            menuRestaurantsRequest.getHarga(),
                            "1",
                            sku,
                            menuRestaurantsRequest.getMerchantSku()
                    );
                    return menuRestaurantsRepo.save(menuRestaurants);
                });
    }

    @Override
    public Mono<MenuRestaurants> deleteRestaurantMenu(String sku, Integer idMenu, MenuRestaurantsRequest menuRestaurantsRequest) {

        return Mono.fromCallable(() -> menuRestaurantsRequest)
                .flatMap(data -> menuRestaurantsRepo.findById(idMenu))
                .doOnNext(i -> {
                    menuRestaurantsRepo.deleteByIdAndRestaurantSku(idMenu,sku).subscribe();
                })
                .flatMap(data -> {
                    MenuRestaurants menuRestaurants = new MenuRestaurants(
                            idMenu,
                            data.getName(),
                            data.getPicture(),
                            data.getCategory(),
                            data.getHarga(),
                            "2",
                            data.getRestaurantSku(),
                            data.getMerchantSku()
                    );
                    return menuRestaurantsRepo.save(menuRestaurants);
                });
    }

    @Override
    public Flux<MenuRestaurants> findAll() {
        return menuRestaurantsRepo.findAll();
    }
}
