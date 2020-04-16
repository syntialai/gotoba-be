package com.example.goToba.service;

import com.example.goToba.model.Galery;
import com.example.goToba.payload.request.GaleryRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Service
public interface GaleryService {
    public List findAllGalery();

    public Mono<Galery> findGaleryBySku(String sku);

    public void addNewFoto(GaleryRequest galeryRequest);

    public void editFotoBySku(GaleryRequest galeryRequest, String sku);
}
