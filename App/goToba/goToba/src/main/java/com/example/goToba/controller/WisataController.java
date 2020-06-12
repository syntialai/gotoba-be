package com.example.goToba.controller;

import com.example.goToba.controller.route.WisataControllerRoute;
import com.example.goToba.payload.*;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.ImageService;
import com.example.goToba.service.WisataService;
import com.example.goToba.service.redisService.implement.WisataRedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */

@CrossOrigin
@RestController
@RequestMapping(WisataControllerRoute.ROUTE_WISATA)
public class WisataController {

    @Autowired
    WisataService wisataService;

    @Autowired
    WisataRepo wisataRepo;

    @Autowired
    WisataRedisServiceImpl wisataRedisService;

    @Autowired
    ImageService imageService;

    @GetMapping(WisataControllerRoute.ROUTE_WISATA_All)
    public Mono<ResponseEntity<?>> findAll() {
        return wisataService.findAll()
                .filter(data -> data.status.equals("active"))
                .collectList().
                map(data -> {
                    return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                });
    }

    @GetMapping(WisataControllerRoute.ROUTE_WISATA_FIND_BY_NAME)
    public ResponseEntity<?> findOne(@PathVariable String name) {
        return ResponseEntity.ok(wisataRepo.findFirstByName(name));
    }

    @GetMapping(WisataControllerRoute.ROUTE_WISATA_FIND_BY_SKU)
    public Mono<ResponseEntity<?>> findBySku(@PathVariable String sku) {
        if (wisataRedisService.hasKey(sku)) {
            return wisataRedisService.findByKey(sku).
                    map(result -> {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, result));
                    });

        }
        return wisataRepo.findFirstBySkuWisata(sku).
                map(result -> {
                    return ResponseEntity.status(HttpStatus.OK).body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, result));
                });

    }

    @PostMapping(WisataControllerRoute.ROUTE_WISATA_ADD_NEW)
    public ResponseEntity<?> addNew(@RequestBody WisataRequest wisataRequest) {
        wisataService.addWisata(wisataRequest).subscribe();
        return ResponseEntity.ok().body(new ActionResponses(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_ADD_WISATA));
    }

    @PutMapping(WisataControllerRoute.ROUTE_WISATA_DETELE_BY_SKU)
    public ResponseEntity<?> deleteBySku(@PathVariable String sku) {
        wisataService.deleteBySku(sku).subscribe();
        return ResponseEntity.ok().body(new DeleteResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS,StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK,StaticResponseMessages.RESPONSE_MESSAGES_FOR_DELETE_WISATA));
    }

    @PutMapping(WisataControllerRoute.ROUTE_WISATA_EDIT_BY_SKU)
    public ResponseEntity<?> updateBySku(@RequestBody WisataRequest request, @PathVariable String sku) {
        wisataService.updateWisata(sku, request).subscribe();
        return ResponseEntity.ok(request);
    }

    @GetMapping(WisataControllerRoute.ROUTE_WISATA_GET_IMAGE)
    public ResponseEntity<byte[]> getImage(@PathVariable String filePath) throws IOException {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageService.loadImage("Wisata", filePath), headers, HttpStatus.OK);
    }


}
