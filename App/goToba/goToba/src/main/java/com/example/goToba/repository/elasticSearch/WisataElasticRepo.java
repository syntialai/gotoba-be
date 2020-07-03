package com.example.goToba.repository.elasticSearch;

import com.example.goToba.model.elastic.Wisata;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/05/2020.
 */
public interface WisataElasticRepo extends ElasticsearchRepository<Wisata,String> {
    Wisata findBySku(String sku);
    List findByName(String name);

    Page<Wisata> search(SearchQuery searchQuery);
}
