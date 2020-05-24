package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
public interface RestaurantControllerRoute {
    public String ROUTE_RESTAURANT = "/restaurant";

    public String ROUTE_RESTAURANT_All = "/";
    public String ROUTE_GET_RESTAURANT_BY_SKU = "/{sku}";
    public String ROUTE_ADD_RESTAURANT_BY_SKU = "/{sku}";

    public String ROUTE_RESTAURANT_BISTRO_TYPES = "/bistro/";
}
