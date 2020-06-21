package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
public interface ReviewsControllerRoute {
    String ROUTE_FOR_REVIEWS = "/review";
    String ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA = "/{sku}";
    String ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA_AND_RATING = "/{sku}/{rating}";
    String ROUTE_GET_ALL_FOR_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA_AND_ID = "/{sku}/id/{id}";
    String ROUTE_ADD_REVIEWS_BY_SKU_RESTAURANTS_OR_WISATA = "/{sku}/user/{userSku}/add";
}
