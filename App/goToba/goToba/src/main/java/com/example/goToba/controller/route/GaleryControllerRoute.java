package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
public interface GaleryControllerRoute {
    public String ROUTE_GALERY = "/gallery";
    public String ROUTE_GALERY_All = "/";
    public String ROUTE_GALERY_ADD_NEW = "/add";
    public String ROUTE_GALERY_FIND_BY_SKU = "/{sku}";
    public String ROUTE_GALERY_UPDATE_BY_SKU = "/edit/{sku}";
    public String ROUTE_GALERY_DELETE_BY_SKU = "/delete/{sku}";
    public String ROUTE_GALERY_SUSPEND_BY_SKU = "/suspend/{sku}";
    public String ROUTE_GALERY_ACTIVATE_BY_SKU = "/activate/{sku}";
}
