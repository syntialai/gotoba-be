package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/05/2020.
 */
public interface TourGuideControllerRoute {
    public String ROUTE_TO_TOUR_GUIDE = "/tour-guide";
    public String ROUTE_TO_TOUR_GUIDE_GET_ALL = "/";
    public String ROUTE_TO_ADD_TOUR_GUIDE = "/";
    public String ROUTE_TO_EDIT_TOUR_GUIDE = "/{sku}";
    public String ROUTE_TO_TOUR_GUIDE_GET_BY_SKU = "/{sku}";
    public String ROUTE_TO_TOUR_GUIDE_GET_BY_Name = "/name/{sku}";
}
