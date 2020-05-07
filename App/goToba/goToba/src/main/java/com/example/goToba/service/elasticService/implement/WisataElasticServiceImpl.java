package com.example.goToba.service.elasticService.implement;

import com.example.goToba.model.elastic.Wisata;
import com.example.goToba.repository.elasticSearch.WisataElasticRepo;
import com.example.goToba.service.elasticService.WisataElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List findAll() {
        return null;
    }

}
