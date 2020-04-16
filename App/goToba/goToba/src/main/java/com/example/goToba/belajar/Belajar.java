package com.example.goToba.belajar;

import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 12/04/2020.
 */
public interface Belajar {
    public Mono<Integer> pangkat(int a, int b);
    Mono<Integer> power(int base, int exponen);
}
