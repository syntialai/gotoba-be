package com.example.goToba.repository;

import com.example.goToba.model.Wisata;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
@Repository
public interface WisataRepo extends ReactiveMongoRepository<Wisata,String> {
}
