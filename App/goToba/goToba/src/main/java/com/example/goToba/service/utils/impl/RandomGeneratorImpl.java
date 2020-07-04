package com.example.goToba.service.utils.impl;

import com.example.goToba.service.utils.RandomGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 03/07/2020.
 */
@Service
public class RandomGeneratorImpl implements RandomGenerator {

    @Override
    public int randInt() {
        int rand = (int) UUID.randomUUID().getMostSignificantBits();
        return rand;
    }
}
