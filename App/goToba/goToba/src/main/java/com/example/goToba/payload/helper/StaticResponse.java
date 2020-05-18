package com.example.goToba.payload.helper;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/05/2020.
 */
public interface StaticResponse {
    public Integer RESPONSE_CODE_SUCCESS = 200;
    public Integer RESPONSE_CODE_SUCCESS_CREATED = 201;
    public Integer RESPONSE_CODE_BAD_REQUEST = 400;
    public Integer RESPONSE_CODE_BAD_UNAUTHORIZED = 401;



    public String RESPONSE_STATUS_SUCCESS_OK = "OK";
    public String RESPONSE_STATUS_SUCCESS_OK_DATA_NULL = "NULL";
    public String RESPONSE_STATUS_ERROR_SERVE = "Internal Server Error";

}
