package com.example.goToba.service.implement;

import com.example.goToba.model.Galery;
import com.example.goToba.payload.request.GaleryRequest;
import com.example.goToba.service.GaleryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Service
public class GaleryServiceImpl implements GaleryService {
    @Override
    public List findAllGalery() {
        return null;
    }

    @Override
    public Mono<Galery> findGaleryBySku(String sku) {
        return null;
    }

    @Override
    public void addNewFoto(GaleryRequest galeryRequest) {

    }

    @Override
    public void editFotoBySku(GaleryRequest galeryRequest, String sku) {

    }
}
