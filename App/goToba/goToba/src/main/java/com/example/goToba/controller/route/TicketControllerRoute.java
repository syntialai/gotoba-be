package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
public interface TicketControllerRoute {
    String ROUTE_TICKET = "/ticket";
    String ROUTE_TICKET_ALL_BY_MERCHANT_SKU = "/merchant/{merchantSku}";
    String ROUTE_TICKET_ALL_BY_CATEGORY = "/category/{category}";
    String ROUTE_TICKET_ALL_BY_SKU = "/{sku}";
    String ROUTE_TICKET_ALL_BY_SKU_USER = "/user/{userSku}";
}
