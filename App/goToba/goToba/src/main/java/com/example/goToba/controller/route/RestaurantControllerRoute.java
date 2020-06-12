package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
public interface RestaurantControllerRoute {
    public String ROUTE_RESTAURANT = "/restaurant";

    public String ROUTE_RESTAURANT_All = "";
    public String ROUTE_GET_RESTAURANT_BY_SKU = "/{sku}";
    public String ROUTE_ADD_RESTAURANT_BY_SKU = "/add/{skuMerchant}";
    public String ROUTE_EDIT_RESTAURANT_BY_SKU = "/edit/{sku}";

    public String ROUTE_RESTAURANT_BISTRO_TYPES = "/bistro/";

    //Menu
    public String ROUTEADD_MENU_RESTAURANTS  = "/{sku}/menu/add";
    public String ROUTE_EDIT_MENU_RESTAURANTS  = "/{sku}/menu/edit/{id}";
    public String ROUTE_DELETE_MENU_RESTAURANTS  = "/{sku}/menu/delete/{id}";
    public String ROUTE_GET_ALL_MENU_BY_SKU_RESTAURANTS  = "/{sku}/menu/";
    public String ROUTE_GET_MENU_BY_ID  = "/menu/{id}";
}
