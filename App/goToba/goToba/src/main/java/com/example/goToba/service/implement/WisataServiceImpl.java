package com.example.goToba.service.implement;

import com.example.goToba.model.SequenceWisata;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.repository.SequenceGaleryRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.WisataService;
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
    SequenceGaleryRepo repo;

    @Override
    public void addWisata(WisataRequest wisataRequest) {
        String sku=skuGenerator(wisataRequest.getCreatedBy(),wisataRequest.getName());
        Wisata wisata=new Wisata(
                sku,
                wisataRequest.getName(),
                wisataRequest.getTitle(),
                wisataRequest.getDescription(),
                wisataRequest.getImage(),
                wisataRequest.getAddress(),
                wisataRequest.getCreatedBy(),
                wisataRequest.getPrice(),
                wisataRequest.getHoursOpen());
        wisataRepo.save(wisata).subscribe();
    }

    @Override
    public Flux<Wisata> findAll() {
        return wisataRepo.findAll();
    }

    @Override
    public String skuGenerator(String creator, String name) {
//        String key =substr(creator) + "_" +substr(name);
//        Mono.fromCallable(()-> repo.findFirstByKey(key))
//                .flatMap(keys ->repo.findFirstByKey(key))
//                .doOnNext(keys -> repo.deleteByKey(key))
//                .doOnNext(keys -> repo.save(new SequenceWisata(key,"000"+(Integer.parseInt(keys.getLast_seq()) + 1))).subscribe())
//                .switchIfEmpty(repo.save(new SequenceWisata(key,"0001")))
//
//        ;
        return null;
    }

    @Override
    public String substr(String str) {
        return str.substring(0, 4).toUpperCase();
    }
}
