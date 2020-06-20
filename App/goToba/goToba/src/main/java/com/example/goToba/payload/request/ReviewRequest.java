package com.example.goToba.payload.request;

/**
 * Created by Sogumontar Hendra Simangunsong on 20/06/2020.
 */
public class ReviewRequest {
    Double rating;
    String comment;

    public ReviewRequest(Double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
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
}
