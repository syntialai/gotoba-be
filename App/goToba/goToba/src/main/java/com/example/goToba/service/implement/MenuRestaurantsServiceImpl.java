package com.example.goToba.service.implement;

import com.example.goToba.model.MenuRestaurants;
import com.example.goToba.payload.helper.StaticStatus;
import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.payload.request.MenuRestaurantsRequest;
import com.example.goToba.repository.MenuRestaurantsRepo;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.MenuRestaurantsService;
import com.example.goToba.service.utils.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/06/2020.
 */
@Service
public class MenuRestaurantsServiceImpl implements MenuRestaurantsService {

    @Autowired
    MenuRestaurantsRepo menuRestaurantsRepo;

    @Autowired
    ImageService imageService;

    @Autowired
    RandomGenerator randomGenerator;

    @Override
    public Mono<MenuRestaurants> findByIdMenu(Integer idMenu) {
        return menuRestaurantsRepo.findById(idMenu)
                .filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE));
    }

    @Override
    public Mono<MenuRestaurants> findByNama(String nama) {
        return menuRestaurantsRepo.findFirstByName(nama)
                .filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE));
    }

    @Override
    public Mono<MenuRestaurants> addRestaurantMenu(String sku, MenuRestaurantsRequest menuRestaurantsRequest) {
        int id= randomGenerator.randInt();
        MenuRestaurants menuRestaurants = new MenuRestaurants(
                id,
                menuRestaurantsRequest.getName(),
                ImagePath.IMAGE_PATH_MENU_RESTAURANTS + ImagePath.IMAGE_CONNECTOR + id + ImagePath.IMAGE_EXTENSION,
                menuRestaurantsRequest.getCategory(),
                menuRestaurantsRequest.getHarga(),
                StaticStatus.STATUS_ACTIVE,
                menuRestaurantsRequest.getRestaurantSku(),
                menuRestaurantsRequest.getMerchantSku()
        );
        System.out.println("test" + menuRestaurantsRequest.getImage());
        if (menuRestaurantsRequest.getImage() != "") {
            try {
                imageService.addPicture(menuRestaurantsRequest.getImage(), menuRestaurants.getId().toString(), ImagePath.IMAGE_PATH_MENU_RESTAURANTS);
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
                            data.getImage(),
                            menuRestaurantsRequest.getCategory(),
                            menuRestaurantsRequest.getHarga(),
                            data.getStatus(),
                            menuRestaurantsRequest.getRestaurantSku(),
                            menuRestaurantsRequest.getMerchantSku()
                    );
                    if (menuRestaurantsRequest.getImage() != "") {
                        try {
                            imageService.addPicture(menuRestaurantsRequest.getImage(), menuRestaurants.getId().toString(), ImagePath.IMAGE_PATH_MENU_RESTAURANTS);
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
                .doOnNext(i -> menuRestaurantsRepo.deleteByIdAndRestaurantSku(idMenu,sku).subscribe())
                .flatMap(data -> {
                    data.setStatus(StaticStatus.STATUS_DELETE);
                    return menuRestaurantsRepo.save(data);
                });
    }

    @Override
    public Flux<MenuRestaurants> findAll() {
        return menuRestaurantsRepo.findAll()
                .filter(data -> data.getStatus().equals(StaticStatus.STATUS_ACTIVE));
    }
}
