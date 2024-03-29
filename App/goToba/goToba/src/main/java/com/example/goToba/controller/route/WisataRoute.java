package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 04/07/2020.
 */
public interface WisataRoute {
    public String ROUTE_WISATA = "/wisata";
    public String ROUTE_WISATA_ADD_NEW = "/add";
    public String ROUTE_WISATA_All = "/";
    public String ROUTE_WISATA_AllBY_MERCHANT = "/merchant/{merchantSku}";
    public String ROUTE_WISATA_FIND_BY_NAME = "/find/{name}";
    public String ROUTE_WISATA_FIND_BY_SKU = "/{sku}";
    public String ROUTE_WISATA_EDIT_BY_SKU = "/edit/{sku}";
    public String ROUTE_WISATA_DETELE_BY_SKU = "/delete/{sku}";
    public String ROUTE_WISATA_GET_IMAGE = "/get/{filePath}";
}
