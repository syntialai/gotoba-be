package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravellingSchedule {
    Integer id;
    String title;
    String description;
    String vacationDestination;
    String skuCustomer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVacationDestination() {
        return vacationDestination;
    }

    public void setVacationDestination(String vacationDestination) {
        this.vacationDestination = vacationDestination;
    }

    public String getSkuCustomer() {
        return skuCustomer;
    }

    public void setSkuCustomer(String skuCustomer) {
        this.skuCustomer = skuCustomer;
    }
}
