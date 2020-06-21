package com.example.goToba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
@NoArgsConstructor
@Data
public class Reviews {
    Integer id;
    Double rating;
    String comment;
    String merchantSku;
    String userSku;

    public Reviews(Integer id, Double rating, String comment, String merchantSku, String userSku) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.merchantSku = merchantSku;
        this.userSku = userSku;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getMerchantSku() {
        return merchantSku;
    }

    public void setMerchantSku(String merchantSku) {
        this.merchantSku = merchantSku;
    }



    public String getUserSku() {
        return userSku;
    }

    public void setUserSku(String userSku) {
        this.userSku = userSku;
    }
}
