package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
public interface TravellingScheduleControllerRoute {
    String ROUTE_TRAVELLING_SCEDULE = "/schedule";
    String ROUTE_TRAVELLING_SCEDULE_ALL = "/";
    String ROUTE_TRAVELLING_SCEDULE_GET_ALL = "/{sku}";
    String ROUTE_TRAVELLING_SCEDULE_GET_DETAIL = "/detail/{scheduleId}";
    String ROUTE_TRAVELLING_SCEDULE_UPDATE_DETAIL = "/edit/{id}";
    String ROUTE_TRAVELLING_SCEDULE_DELETE_DETAIL = "/delete/{id}";
    String ROUTE_ADD_TRAVELLING_SCEDULE = "/add/{sku}";
}
