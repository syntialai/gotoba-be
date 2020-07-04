package com.example.goToba.service.utils.impl;

import com.example.goToba.service.utils.SkuGenerator;
import org.springframework.stereotype.Service;

/**
 * Created by Sogumontar Hendra Simangunsong on 22/06/2020.
 */

@Service
public class SkuGeneratorImpl implements SkuGenerator {
    @Override
    public String substring(String str) {
        if (str.length() >= 4) {
            return str.substring(0, 4).toUpperCase();
        }
        return str.toUpperCase();
    }
}
