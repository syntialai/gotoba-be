package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
public interface OrderDetailControllerRoute {
    public String ROUTE_ORDER = "/order";
    public String ROUTE_ORDER_DETAIL_BY_SKU = "/sku/{sku}";
    public String ROUTE_ORDER_DETAIL_BY_SKU_MERCHANT = "/merchant/{merchantSku}";
    public String ROUTE_ORDER_DETAIL_BY_SKU_USER = "/{userSku}";
    public String ROUTE_ADD_ORDER_DETAIL_BY_SKU_USER = "/add/{userSku}";

}
