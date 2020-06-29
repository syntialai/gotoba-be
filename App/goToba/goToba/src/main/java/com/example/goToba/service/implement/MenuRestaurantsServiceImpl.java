package com.example.goToba.service.implement;

import com.example.goToba.model.MenuRestaurants;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.helper.Strings;
import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import com.example.goToba.repository.MenuRestaurantsRepo;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.MenuRestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/06/2020.
 */
@Service
public class MenuRestaurantsServiceImpl implements MenuRestaurantsService {

    @Autowired
    MenuRestaurantsRepo menuRestaurantsRepo;

    @Autowired
    ImageService imageService;

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
        int id= (int) UUID.randomUUID().getLeastSignificantBits();
        MenuRestaurants menuRestaurants = new MenuRestaurants(
                id,
                menuRestaurantsRequest.getName(),
                ImagePath.IMAGE_PATH_MENU_RESTAURANTS + ImagePath.IMAGE_CONNECTOR + id + ImagePath.IMAGE_EXTENSION,
                menuRestaurantsRequest.getCategory(),
                menuRestaurantsRequest.getHarga(),
                Strings.STATUS_ACTIVE,
                menuRestaurantsRequest.getRestaurantSku(),
                menuRestaurantsRequest.getMerchantSku()
        );
        if (menuRestaurantsRequest.getPicture() != "") {
            try {
                imageService.addPicture(menuRestaurantsRequest.getPicture(), menuRestaurants.getId().toString(), ImagePath.IMAGE_PATH_MENU_RESTAURANTS);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return menuRestaurantsRepo.save(menuRestaurants);
    }

    @Override
    public Mono<MenuRestaurants> editRestaurantMenu(String sku, Integer idMenu, MenuRestaurantsRequest menuRestaurantsRequest) {
        return Mono.fromCallable(() -> menuRestaurantsRequest)
                .flatMap(datas -> menuRestaurantsRepo.findById(idMenu))
                .doOnNext(i -> menuRestaurantsRepo.deleteById(idMenu).subscribe())
                .flatMap(data -> {
                    MenuRestaurants menuRestaurants = new MenuRestaurants(
                            idMenu,
                            menuRestaurantsRequest.getName(),
                            data.getPicture(),
                            menuRestaurantsRequest.getCategory(),
                            menuRestaurantsRequest.getHarga(),
                            data.getStatus(),
                            menuRestaurantsRequest.getRestaurantSku(),
                            menuRestaurantsRequest.getMerchantSku()
                    );
                    if (menuRestaurantsRequest.getPicture() != "") {
                        try {
                            imageService.addPicture(menuRestaurantsRequest.getPicture(), menuRestaurants.getId().toString(), ImagePath.IMAGE_PATH_MENU_RESTAURANTS);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
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
                            Strings.STATUS_DELETE,
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
