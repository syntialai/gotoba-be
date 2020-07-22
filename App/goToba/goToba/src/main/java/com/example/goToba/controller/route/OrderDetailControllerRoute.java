package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/06/2020.
 */
public interface OrderDetailControllerRoute {
    public String ROUTE_ORDER = "/order";
    public String ROUTE_ORDER_DETAIL_BY_SKU = "/{sku}";
    public String ROUTE_ORDER_DETAIL_ALL = "/all/";
    public String ROUTE_ORDER_DETAIL_BY_SKU_MERCHANT = "/merchant/{merchantSku}";
    public String ROUTE_ORDER_DETAIL_BY_SKU_USER = "/user/{userSku}";
    public String ROUTE_ADD_ORDER_DETAIL_BY_SKU_USER = "/user/{userSku}/add";
    public String ROUTE_CHECKOUT_ORDER_DETAIL_BY_SKU_USER = "/checkout/{userSku}";
    public String ROUTE_EDIT_ORDER_DETAIL_BY_SKU= "/edit/{sku}";
    public String ROUTE_DELETE_ORDER_DETAIL_BY_SKU= "/delete/{sku}";

}
