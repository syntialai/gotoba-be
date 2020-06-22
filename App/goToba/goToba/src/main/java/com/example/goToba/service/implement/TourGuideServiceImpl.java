package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceTourGuide;
import com.example.goToba.model.TourGuide;
import com.example.goToba.payload.request.TourGuideRequest;
import com.example.goToba.repository.SequenceTourGuideRepo;
import com.example.goToba.repository.TourGuideRepo;
import com.example.goToba.service.TourGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
@Service
public class TourGuideServiceImpl implements TourGuideService {

    @Autowired
    TourGuideRepo tourGuideRepo;

    @Autowired
    SequenceTourGuideRepo sequenceTourGuideRepo;

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
        return tourGuideRepo.findFirstByName(name);
    }

    @Override
    public Mono<TourGuide> addTourGuide(TourGuideRequest tourGuideRequest) {
        String awal = "000";
        String key = substr("TG_" + substr(tourGuideRequest.getName()));
        Mono<TourGuide> tourGuideMono = Mono.fromCallable(() -> tourGuideRequest)
                .flatMap(dat -> sequenceTourGuideRepo.findFirstByKey(key))
                .doOnNext(dat -> sequenceTourGuideRepo.deleteByKey(key).subscribe())
                .doOnNext(dat -> sequenceTourGuideRepo.save(new SequenceTourGuide(key, awal + (Integer.parseInt(dat.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceTourGuideRepo.save(new SequenceTourGuide(key, awal + "1")))
                .flatMap(dat -> sequenceTourGuideRepo.findFirstByKey(key))
                .flatMap(data -> {
                    TourGuide tourGuide = new TourGuide(
                            (int)UUID.randomUUID().getMostSignificantBits(),
                            data.getKey() + "_000" + Integer.parseInt(data.getLast_seq()),
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
                            "active"
                            );
                    return tourGuideRepo.save(tourGuide);
                });
        return tourGuideMono;
    }

    @Override
    public Mono<TourGuide> editTourGuide(TourGuideRequest tourGuideRequest, String sku) {
        return Mono.fromCallable(() -> tourGuideRequest)
                .flatMap(data -> tourGuideRepo.findBySku(sku))
                .doOnNext(i -> {
                    tourGuideRepo.deleteBySku(sku).subscribe();
                })
                .flatMap(data ->{
                    TourGuide tourGuide=new TourGuide(
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
                            data.getStatus()
                    );
                    tourGuideRepo.save(tourGuide).subscribe();
                    return tourGuideRepo.findBySku(sku);
                });

    }

    @Override
    public Mono<TourGuide> deleteTourGuide(String sku) {
        return tourGuideRepo.findBySku(sku)
                .flatMap(data -> tourGuideRepo.findBySku(sku))
                .doOnNext(i -> tourGuideRepo.deleteBySku(sku).subscribe())
                .flatMap(data ->{
                    TourGuide tourGuide=new TourGuide(
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
                            "deleted"
                    );
                    tourGuideRepo.save(tourGuide).subscribe();
                    return tourGuideRepo.findBySku(sku);
                });

    }

    @Override
    public String substr(String str) {
        return str.substring(0, 4).toUpperCase();
    }
}
