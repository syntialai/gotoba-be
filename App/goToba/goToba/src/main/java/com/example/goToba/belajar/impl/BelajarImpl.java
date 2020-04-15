package com.example.goToba.belajar.impl;

import com.example.goToba.belajar.Belajar;
import reactor.core.publisher.Mono;

/**
 * Created by Sogumontar Hendra Simangunsong on 12/04/2020.
 */
public class BelajarImpl implements Belajar {

    @Override
    public Mono<Integer> pangkat(int a, int b) {
        Mono<Integer> mono2 = Mono.just(a)
                .flatMap(val -> Mono.just(a))
                .doOnNext(base -> System.out.println("Base = " + base))
                .flatMap(val -> Mono.just(b))
                .doOnNext(exponen -> System.out.println("eksponen = " + exponen))
                .flatMap(res -> power(a, b))
                .doOnNext(res -> System.out.println("Hasil " + a + " pangkat " + b + " adalah : " + res));
        return (Mono<Integer>) mono2.subscribe();
    }

    @Override
    public Mono<Integer> power(int base, int exponen) {
        return Mono.just((int) Math.pow(base, exponen));
    }

}
