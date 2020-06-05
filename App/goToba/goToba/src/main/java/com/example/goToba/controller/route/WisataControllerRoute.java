package com.example.goToba.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */
public interface WisataControllerRoute {
    public String ROUTE_WISATA = "/wisata";
    public String ROUTE_WISATA_ADD_NEW = "/add";
    public String ROUTE_WISATA_All = "/";
    public String ROUTE_WISATA_FIND_BY_NAME = "/find/{name}";
    public String ROUTE_WISATA_FIND_BY_SKU = "/{sku}";
    public String ROUTE_WISATA_EDIT_BY_SKU = "/edit/{sku}";
    public String ROUTE_WISATA_DETELE_BY_SKU = "/delete/{sku}";


}
