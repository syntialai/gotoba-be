package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/03/2020.
 */
public interface UserControllerRoute {
    public String ROUTE_AUTH= "/auth";
    public String ROUTE_SIGN_UP = "/signup";
    public String ROUTE_SIGN_IN = "/signin";
    public String ROUTE_USER_FIND_ALL = "/";
    public String ROUTE_USER_FIND_BY_NICKNAME = "/nickname/{nickname}";
}
