package com.example.goToba.payload.helper;

/**
 * Created by Sogumontar Hendra Simangunsong on 04/06/2020.
 */
public interface StaticResponseMessages {
    public String RESPONSE_MESSAGE_USER_REGISTERED = "User registered successfully";
    public String RESPONSE_MESSAGE_USER_UNAUTHORIZED = "username or password is wrong";
    public String RESPONSE_MESSAGES_FOR_ADD_WISATA = "Tambah data wisata sukses";
    public String RESPONSE_MESSAGES_FOR_ADD_TRAVELLING_SCHEDULE = "Tambah schedule sukses";
    public String RESPONSE_MESSAGES_FOR_DELETE_WISATA = "Delete success!";
    public String RESPONSE_MESSAGES_FOR_DELETE_SCHEDULE = "Schedule deleted with id ";
    public String RESPONSE_MESSAGES_FOR_UPDATE_SUKSES = "Update Sukses";
    public String RESPONSE_MESSAGES_FOR_DELETE_SUKSES = "Delete Sukses";
    public String RESPONSE_MESSAGES_FOR_NOT_FOUND = "Invalid Request: Cannot find ";
    public String RESPONSE_MESSAGES_FOR_DUPLICATE_SOURCE = "The request could not be completed due to a conflict with the current state of the target resource";
    public String RESPONSE_MESSAGES_FOR_NOT_FOUND_DELETE = "Invalid Request: Cannot delete ";
    public String RESPONSE_MESSAGES_FOR_EMPTY = "Message: There is no data ";
    public String RESPONSE_MESSAGES_FOR_EMPTY_SCHEDULE = "Message: There is no schedule found in that user sku";
    public String RESPONSE_MESSAGES_FOR_EMPTY_NEAR_BY_LOCATION_RESTAURANT = "Message: There is no Restaurants near by your current location";
    public String RESPONSE_MESSAGES_FOR_EMPTY_NEAR_BY_LOCATION_WISATA = "Message: There is no Wisata near by your current location";
    public String RESPONSE_MESSAGES_FOR_SUCCESS_DELETE_TICKET = "Successfully delete ticket with sku ";
}
