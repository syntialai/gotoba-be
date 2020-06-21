package com.example.goToba.payload.request;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 20/06/2020.
 */

@NoArgsConstructor
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
