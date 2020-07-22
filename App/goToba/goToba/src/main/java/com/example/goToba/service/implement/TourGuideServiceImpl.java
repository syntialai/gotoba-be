package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceTourGuide;
import com.example.goToba.model.TourGuide;
import com.example.goToba.payload.helper.StockKeepingUnit;
import com.example.goToba.payload.helper.Strings;
import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.payload.request.TourGuideRequest;
import com.example.goToba.repository.SequenceTourGuideRepo;
import com.example.goToba.repository.TourGuideRepo;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.utils.SkuGenerator;
import com.example.goToba.service.TourGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
@Service
public class TourGuideServiceImpl implements TourGuideService {

    @Autowired
    SkuGenerator skuGenerator;

    @Autowired
    TourGuideRepo tourGuideRepo;

    @Autowired
    SequenceTourGuideRepo sequenceTourGuideRepo;

    @Autowired
    ImageService imageService;

    @Override
    public Flux<TourGuide> findAll() {
        return tourGuideRepo.findAll();
    }

    @Override
    public Mono<TourGuide> findBySku(String sku) {
        return tourGuideRepo.findBySku(sku);
    }

    @Override
    public Mono<TourGuide> findByName(String name) {
        System.out.println(tourGuideRepo.findFirstByName(name));
        return tourGuideRepo.findFirstByName(name);
    }

    @Override
    public Mono<TourGuide> addTourGuide(TourGuideRequest tourGuideRequest) {
        String key = skuGenerator.substring(StockKeepingUnit.TOUD_GUIDE + StockKeepingUnit.SKU_CONNECTOR + skuGenerator.substring(tourGuideRequest.getName()));
        return Mono.fromCallable(() -> tourGuideRequest)
                .flatMap(dat -> sequenceTourGuideRepo.findFirstByKey(key))
                .doOnNext(dat -> sequenceTourGuideRepo.deleteByKey(key).subscribe())
                .doOnNext(dat -> sequenceTourGuideRepo.save(new SequenceTourGuide(key, StockKeepingUnit.SKU_DATA_BEGINNING + (Integer.parseInt(dat.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceTourGuideRepo.save(new SequenceTourGuide(key, StockKeepingUnit.SKU_DATA_BEGINNING + "1")))
                .flatMap(dat -> sequenceTourGuideRepo.findFirstByKey(key))
                .flatMap(data -> {
                    TourGuide tourGuide = new TourGuide(
                            (int) UUID.randomUUID().getMostSignificantBits(),
                            data.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(data.getLast_seq()),
                            tourGuideRequest.getName(),
                            tourGuideRequest.getAge(),
                            tourGuideRequest.getOccupation(),
                            tourGuideRequest.getLocation(),
                            tourGuideRequest.getRating(),
                            tourGuideRequest.getLanguage(),
                            tourGuideRequest.getAvailableLocation(),
                            tourGuideRequest.getPhone(),
                            tourGuideRequest.getEmail(),
                            tourGuideRequest.getWhatsapp(),
                            tourGuideRequest.getExperience(),
                            tourGuideRequest.getDescription(),
                            Strings.STATUS_ACTIVE,
                            tourGuideRequest.getGender(),
                            ImagePath.IMAGE_PATH_TOURE_GUIDE + ImagePath.IMAGE_CONNECTOR  + data.getKey() + StockKeepingUnit.SKU_CONNECTOR + StockKeepingUnit.SKU_DATA_BEGINNING + Integer.parseInt(data.getLast_seq()) + ImagePath.IMAGE_EXTENSION
                            );
                    if (tourGuideRequest.getImage() != "") {
                        try {
                            imageService.addPicture(tourGuideRequest.getImage(), tourGuide.getSku(), ImagePath.IMAGE_PATH_TOURE_GUIDE);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return tourGuideRepo.save(tourGuide);
                });
    }

    @Override
    public Mono<TourGuide> editTourGuide(TourGuideRequest tourGuideRequest, String sku) {
        return Mono.fromCallable(() -> tourGuideRequest)
                .flatMap(data -> tourGuideRepo.findBySku(sku))
                .doOnNext(i -> {
                    tourGuideRepo.deleteBySku(sku).subscribe();
                })
                .flatMap(data -> {
                    TourGuide tourGuide = new TourGuide(
                            data.getId(),
                            sku,
                            tourGuideRequest.getName(),
                            tourGuideRequest.getAge(),
                            tourGuideRequest.getOccupation(),
                            tourGuideRequest.getLocation(),
                            tourGuideRequest.getRating(),
                            tourGuideRequest.getLanguage(),
                            tourGuideRequest.getAvailableLocation(),
                            tourGuideRequest.getPhone(),
                            tourGuideRequest.getEmail(),
                            tourGuideRequest.getWhatsapp(),
                            tourGuideRequest.getExperience(),
                            tourGuideRequest.getDescription(),
                            data.getStatus(),
                            tourGuideRequest.getGender(),
                            data.getImage()
                    );
                    if (tourGuideRequest.getImage() != "") {
                        try {
                            imageService.addPicture(tourGuideRequest.getImage(), tourGuide.getSku(), ImagePath.IMAGE_PATH_TOURE_GUIDE);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    tourGuideRepo.save(tourGuide).subscribe();
                    return tourGuideRepo.findBySku(sku);
                });

    }

    @Override
    public Mono<TourGuide> deleteTourGuide(String sku) {
        return tourGuideRepo.findBySku(sku)
                .flatMap(data -> tourGuideRepo.findBySku(sku))
                .doOnNext(i -> tourGuideRepo.deleteBySku(sku).subscribe())
                .flatMap(data -> {
                    TourGuide tourGuide = new TourGuide(
                            data.getId(),
                            sku,
                            data.getName(),
                            data.getAge(),
                            data.getOccupation(),
                            data.getLocation(),
                            data.getRating(),
                            data.getLanguage(),
                            data.getAvailableLocation(),
                            data.getPhone(),
                            data.getEmail(),
                            data.getWhatsapp(),
                            data.getExperience(),
                            data.getDescription(),
                            Strings.STATUS_DELETE,
                            data.getGender(),
                            data.getImage()
                    );
                    tourGuideRepo.save(tourGuide).subscribe();
                    return tourGuideRepo.findBySku(sku);
                });

    }

}
