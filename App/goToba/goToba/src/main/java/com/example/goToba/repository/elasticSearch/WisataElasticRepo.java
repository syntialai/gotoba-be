package com.example.goToba.repository.elasticSearch;

import com.example.goToba.model.elastic.WisataElastic;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/05/2020.
 */
public interface WisataElasticRepo extends ElasticsearchRepository<WisataElastic,String> {
    Mono<WisataElastic> findBySku(String sku);
    List findByName(String name);
    Boolean deleteBySku(String sku);
    Page<WisataElastic> search(SearchQuery searchQuery);
}
