package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/06/2020.
 */
public interface NearByLocationControllerRoute {
    String ROUTE_TO_NEAR_BY_LOCATION = "/nearBy";
    String ROUTE_TO_NEAR_BY_LOCATION_WISATA = "/{longitude}/{lat}";
    String ROUTE_TO_NEAR_BY_LOCATION_RESTAURANTS = "/restaurants/{longitude}/{lat}";
}
