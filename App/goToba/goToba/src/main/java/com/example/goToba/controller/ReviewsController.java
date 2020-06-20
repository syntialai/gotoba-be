package com.example.goToba.controller;

import com.example.goToba.controller.route.ReviewsControllerRoute;
import com.example.goToba.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/06/2020.
 */
@RestController
@RequestMapping(ReviewsControllerRoute.ROUTE_FOR_REVIEWS)
public class ReviewsController {
    @Autowired
    ReviewsService reviewsService;
}
