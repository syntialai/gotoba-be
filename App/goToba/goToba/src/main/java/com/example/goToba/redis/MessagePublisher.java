package com.example.goToba.redis;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/04/2020.
 */
public interface MessagePublisher {
    void publish(final String message);
}
