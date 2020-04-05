package com.example.goToba.service.implement;

import com.example.goToba.model.Wisata;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.WisataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@Service
public class WisataServiceImpl implements WisataService {

    @Autowired
    WisataRepo wisataRepo;

    @Override
    public void addWisata(WisataRequest wisataRequest) {
        String sku="skuTest";
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
}
