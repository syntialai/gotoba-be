package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
public interface TravellingScheduleControllerRoute {
    String ROUTE_TRAVELLING_SCEDULE = "/schedule";
    String ROUTE_TRAVELLING_SCEDULE_ALL = "/";
    String ROUTE_TRAVELLING_SCEDULE_GET_ALL = "/{userSku}";
    String ROUTE_TRAVELLING_SCEDULE_GET_DETAIL = "/detail/{sku}";
    String ROUTE_TRAVELLING_SCEDULE_UPDATE_DETAIL = "/edit/{sku}";
    String ROUTE_TRAVELLING_SCEDULE_DELETE_DETAIL = "/delete/{sku}";
    String ROUTE_ADD_TRAVELLING_SCEDULE = "/{userSku}/add";
}
