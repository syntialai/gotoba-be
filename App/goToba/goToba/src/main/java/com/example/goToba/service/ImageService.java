package com.example.goToba.service;

import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 12/06/2020.
 */
public interface ImageService {

    byte[] loadImage(String path,String fileName) throws IOException;
    void addPicture(String base64, String sku, String path) throws IOException;
}
