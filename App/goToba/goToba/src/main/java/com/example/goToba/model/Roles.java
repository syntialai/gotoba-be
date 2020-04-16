package com.example.goToba.model;

import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@NoArgsConstructor
public class Roles {
    private String id= UUID.randomUUID().toString();
    private RoleName name;

    public Roles(String id, RoleName name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
