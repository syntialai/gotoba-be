package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/06/2020.
 */
public interface PaymentControllerRoute {
    public String ROUTE_PAYMENT = "/pay";
    public String ROUTE_PAYMENT_BY_MERCHANT_SKU = "/merchant/{merchantSku}";
    public String ROUTE_PAYMENT_BY_SKU = "/sku/{sku}";
    public String ROUTE_PAYMENT_BY_MERCHANT_SKU_AND_CATEGORY = "/merchant/{merchantSku}/category/{category}";
    public String ROUTE_PAYMENT_BY_USER_SKU_AND_STATUS = "/user/{userSku}/status/{status}";
    public String ROUTE_ADD_PAYMENT_BY_USER_SKU = "/add/{userSku}";
    public String ROUTE_EDIT_PAYMENT_BY_SKU = "/edit/{sku}";
}
