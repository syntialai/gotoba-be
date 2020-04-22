package com.example.goToba.model;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 22/04/2020.
 */
@NoArgsConstructor
public class SequenceGalery {
    private String key;
    private String last_seq;

    public SequenceGalery(String key, String last_seq) {
        this.key = key;
        this.last_seq = last_seq;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLast_seq() {
        return last_seq;
    }

    public void setLast_seq(String last_seq) {
        this.last_seq = last_seq;
    }
}
