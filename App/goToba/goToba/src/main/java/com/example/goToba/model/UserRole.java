package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/04/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    public String sku_user;
    private Integer role_id;

    public String getSku_user() {
        return sku_user;
    }

    public void setSku_user(String sku_user) {
        this.sku_user = sku_user;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
