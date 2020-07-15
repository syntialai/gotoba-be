package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
public interface TicketControllerRoute {
    String ROUTE_TICKET = "/ticket";
    String ROUTE_TICKET_ALL = "/";
    String ROUTE_TICKET_ALL_BY_MERCHANT_SKU = "/merchant/{merchantSku}";
    String ROUTE_TICKET_ALL_BY_CATEGORY = "/category/{category}";
    String ROUTE_TICKET_BY_SKU = "/{sku}";
    String ROUTE_TICKET_ALL_BY_SKU_USER = "/user/{userSku}";
    String ROUTE_TICKET_ADD_BY_MERCHANT_SKU = "/merchant/{merchantSku}/add";
    String ROUTE_TICKET_EDIT_BY_SKU = "/edit/{sku}";
    String ROUTE_TICKET_DELETE_BY_SKU = "/delete/{sku}";
}
