package com.example.goToba.payload.helper;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/06/2020.
 */
public interface StaticStatus {
    public String STATUS_DELETE = "deleted";
    public String STATUS_ACTIVE = "active";

    public Integer STATUS_CANCEL_REJECT_OR_DELETE = 0;
    public Integer STATUS_CART = 1;
    public Integer STATUS_CHECKOUT = 2;
    public Integer STATUS_APPROVE = 3;
}
