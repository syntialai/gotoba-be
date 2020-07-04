package com.example.goToba.service.elasticService;

import com.example.goToba.model.elastic.WisataElastic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/05/2020.
 */
public interface WisataElasticService {
    List<WisataElastic> findOne(String nama);
    Flux<WisataElastic> findAll();
    WisataElastic save(WisataElastic wisata);
    Boolean deleteBySku(String sku);
    Mono<WisataElastic> findBySku(String sku);
}
