package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */
public interface UserControllerRoute {
    public String ROUTE_AUTH= "/user";
    public String ROUTE_USER_FIND_ALL = "/";
    public String ROUTE_USER_FIND_ALL_CUSTOMER = "/customer/";
    public String ROUTE_USER_FIND_BY_USERNAME = "/{username}";
    public String ROUTE_USER_FIND_BY_SKU = "/sku/{sku}";
    public String ROUTE_USER_FIND_BY_STATUS_ACTIVE= "/active";
    public String ROUTE_USER_FIND_BY_STATUS_BLOCKED= "/blocked";
    public String ROUTE_USER_EDIT_BY_SKU= "/edit/{sku}";
}
