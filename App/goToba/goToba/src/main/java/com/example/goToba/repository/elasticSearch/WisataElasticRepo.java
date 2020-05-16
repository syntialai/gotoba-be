package com.example.goToba.repository.elasticSearch;

import com.example.goToba.model.elastic.Wisata;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/05/2020.
 */
public interface WisataElasticRepo extends ElasticsearchRepository<Wisata,String> {
    Wisata findBySkuWisata(String sku);
    List findByName(String name);
}
