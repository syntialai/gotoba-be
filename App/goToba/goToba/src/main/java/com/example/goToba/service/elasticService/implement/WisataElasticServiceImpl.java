package com.example.goToba.service.elasticService.implement;

import com.example.goToba.model.elastic.WisataElastic;
import com.example.goToba.repository.elasticSearch.WisataElasticRepo;
import com.example.goToba.service.elasticService.WisataElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/05/2020.
 */
@Service
public class WisataElasticServiceImpl implements WisataElasticService {

    @Autowired
    WisataElasticRepo wisataElasticRepo;

    @Override
    public List findOne(String nama) {
        return wisataElasticRepo.findByName(nama);
    }

    @Override
    public Flux<WisataElastic> findAll() {
        return null;
    }

    @Override
    public WisataElastic save(WisataElastic wisata) {
        return wisataElasticRepo.save(wisata);
    }

    @Override
    public Boolean deleteBySku(String sku) {
        return wisataElasticRepo.deleteBySku(sku);
    }

    @Override
    public Mono<WisataElastic> findBySku(String sku) {
        return wisataElasticRepo.findBySku(sku);
    }

}
