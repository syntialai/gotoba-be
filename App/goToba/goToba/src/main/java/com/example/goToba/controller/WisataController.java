package com.example.goToba.controller;

import com.example.goToba.controller.route.WisataControllerRoute;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.*;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.helper.Strings;
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
import java.sql.Timestamp;

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
                .filter(data -> data.status.equals(Strings.STATUS_ACTIVE))
                .collectList().
                        map(data -> {
                            if (data.size() != 0) {
                                return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, data));
                            }
                            return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_All));
                        }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_All)));
    }

    @GetMapping(WisataControllerRoute.ROUTE_WISATA_AllBY_MERCHANT)
    public Mono<ResponseEntity<?>> findAllBySkuMerchant(@PathVariable String merchantSku){
        return wisataService.findAll().filter(data -> data.createdBy.equals(merchantSku))
                .collectList()
                .map(data -> {
                    if(data.size()!=0){
                        return  ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS,StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK,data));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_AllBY_MERCHANT));
                }).defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_EMPTY, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_AllBY_MERCHANT)));
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
        return wisataRepo.findFirstBySku(sku).
                map(result -> {
                    if (result.getSku() != null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, result));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "wisata with that sku " + sku, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_FIND_BY_SKU));
                })
                .defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "wisata with that sku " + sku, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_FIND_BY_SKU)));

    }

    @PostMapping(WisataControllerRoute.ROUTE_WISATA_ADD_NEW)
    public ResponseEntity<?> addNew(@RequestBody WisataRequest wisataRequest) {
        wisataService.addWisata(wisataRequest).subscribe();
        return ResponseEntity.ok().body(new ActionResponses(StaticResponseCode.RESPONSE_CODE_SUCCESS_CREATED, StaticResponseStatus.RESPONSE_STATUS_CREATED, StaticResponseMessages.RESPONSE_MESSAGES_FOR_ADD_WISATA));
    }

    @DeleteMapping(WisataControllerRoute.ROUTE_WISATA_DETELE_BY_SKU)
    public Mono<ResponseEntity<?>> deleteBySku(@PathVariable String sku) {
        return Mono.fromCallable(() -> wisataService.deleteBySku(sku).subscribe())
                .flatMap(data -> wisataService.findBySku(sku))
                .map(data -> {
                    if (data.getSku() != null) {
                        return ResponseEntity.ok().body(new DeleteResponse(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_DELETE_WISATA));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND_DELETE + "wisata with that sku " + sku, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_DETELE_BY_SKU));
                })
                .defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND_DELETE + "wisata with that sku " + sku, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_DETELE_BY_SKU)));



    }

    @PutMapping(WisataControllerRoute.ROUTE_WISATA_EDIT_BY_SKU)
    public Mono<ResponseEntity<?>> updateBySku(@RequestBody WisataRequest request, @PathVariable String sku) {
        return Mono.fromCallable(() -> wisataService.updateWisata(sku, request).subscribe())
                .flatMap(data -> wisataService.findBySku(sku))
                .map(data -> {
                    if (data.getSku() != null) {
                        return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, request));
                    }
                    return ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "wisata with that sku " + sku, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_EDIT_BY_SKU));
                })
                .defaultIfEmpty(ResponseEntity.ok().body(new NotFoundResponse(new Timestamp(System.currentTimeMillis()).toString(), StaticResponseCode.RESPONSE_CODE_NOT_FOUND, StaticResponseStatus.RESPONSE_STATUS_ERROR_NOT_FOUND, StaticResponseMessages.RESPONSE_MESSAGES_FOR_NOT_FOUND + "wisata with that sku " + sku, WisataControllerRoute.ROUTE_WISATA + WisataControllerRoute.ROUTE_WISATA_EDIT_BY_SKU)));
    }


}
