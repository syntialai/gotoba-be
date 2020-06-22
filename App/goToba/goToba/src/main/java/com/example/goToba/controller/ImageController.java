package com.example.goToba.controller;

import com.example.goToba.controller.route.ImageControllerRoute;
import com.example.goToba.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 22/06/2020.
 */

@RestController
@RequestMapping(ImageControllerRoute.IMAGE_ROUTE_ALL)
public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping(ImageControllerRoute.GET_IMAGE_BY_FILE_NAME)
    public ResponseEntity<byte[]> getImage(@PathVariable String filePath, @PathVariable String fileName) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageService.loadImage(filePath+"/"+fileName), headers, HttpStatus.OK);
    }
}
