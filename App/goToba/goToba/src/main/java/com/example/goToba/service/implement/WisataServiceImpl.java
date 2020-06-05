package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceWisata;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.redis.template.RedisKeys;
import com.example.goToba.repository.SequenceWisataRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.WisataService;
import com.example.goToba.service.redisService.WisataRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@Service
public class WisataServiceImpl implements WisataService {

    @Autowired
    WisataRepo wisataRepo;

    @Autowired
    SequenceWisataRepo sequenceWisataRepo;

    @Autowired
    WisataRedisService wisataRedisService;

    @Override
    public Mono<Wisata> addWisata(WisataRequest wisataRequest) {
        String awal = "000";
        String key = substr(wisataRequest.getCreatedBy()) + "_" + substr(wisataRequest.getName());
        Mono<Wisata> wisataMono = Mono.fromCallable(() -> wisataRequest)
                .flatMap(dat -> sequenceWisataRepo.findFirstByKey(key))
                .doOnNext(dat -> sequenceWisataRepo.deleteByKey(key).subscribe())
                .doOnNext(dat -> sequenceWisataRepo.save(new SequenceWisata(key, awal + (Integer.parseInt(dat.getLast_seq()) + 1))).subscribe())
                .switchIfEmpty(sequenceWisataRepo.save(new SequenceWisata(key, awal + "1")))
                .flatMap(dat -> sequenceWisataRepo.findFirstByKey(key))
                .flatMap(data -> {
                    Wisata wisata = new Wisata(
                            data.getKey() + "_000" + Integer.parseInt(data.getLast_seq()),
                            wisataRequest.getName(),
                            wisataRequest.getTitle(),
                            wisataRequest.getDescription(),
                            wisataRequest.getImage(),
                            wisataRequest.getAddress(),
                            wisataRequest.getCreatedBy(),
                            wisataRequest.getPrice(),
                            wisataRequest.getHoursOpen(),
                            "active"
                    );
                    wisataRedisService.add(wisata);
                    return wisataRepo.save(wisata);
                });
        return wisataMono;
    }

    @Override
    public Flux<Wisata> findAll() {
        return wisataRepo.findAll();
    }


    @Override
    public String substr(String str) {
        return str.substring(0, 4).toUpperCase();
    }

    @Override
    public Mono<Wisata> updateWisata(String sku, WisataRequest wisataRequest) {
        return Mono.fromCallable(() -> wisataRequest)
                .flatMap(data -> wisataRepo.findFirstBySkuWisata(sku))
                .doOnNext(i -> {
                    wisataRepo.deleteBySkuWisata(sku).subscribe();
                })
                .flatMap(data -> {
                    Wisata wisata = new Wisata(
                            sku,
                            wisataRequest.getName(),
                            wisataRequest.getTitle(),
                            wisataRequest.getDescription(),
                            wisataRequest.getImage(),
                            wisataRequest.getAddress(),
                            wisataRequest.getCreatedBy(),
                            wisataRequest.getPrice(),
                            wisataRequest.getHoursOpen(),
                            data.getStatus()
                    );
                    wisataRedisService.deleteByKey(sku);
                    wisataRedisService.add(wisata);
                    return wisataRepo.save(wisata);
                });
    }

    @Override
    public Mono<Wisata> deleteBySku(String sku) {
        return wisataRepo.findFirstBySkuWisata(sku)
                .doOnNext(i -> {
                    wisataRepo.deleteBySkuWisata(sku).subscribe();
                })
                .flatMap(data -> {
                    Wisata wisata = new Wisata(
                            sku,
                            data.getName(),
                            data.getTitle(),
                            data.getDescription(),
                            data.getImage(),
                            data.getAddress(),
                            data.getCreatedBy(),
                            data.getPrice(),
                            data.getHoursOpen(),
                            "blocked"
                    );
                    return wisataRepo.save(wisata);
                });
    }

    @Override
    public Mono<Wisata> findBySku(String sku) {
        return wisataRepo.findFirstBySkuWisata(sku)
                .flatMap(req -> {
                    Wisata wisata = new Wisata(
                            sku,
                            req.getName(),
                            req.getTitle(),
                            req.getDescription(),
                            req.getImage(),
                            req.getAddress(),
                            req.getCreatedBy(),
                            req.getPrice(),
                            req.getHoursOpen(),
                            "active"
                    );
                    return wisataRepo.findFirstBySkuWisata(sku);
                });
    }
}
