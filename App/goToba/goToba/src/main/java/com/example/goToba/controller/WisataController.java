package com.example.goToba.controller;

import com.example.goToba.controller.route.WisataControllerRoute;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.ActionResponses;
import com.example.goToba.payload.ApiResponse;
import com.example.goToba.payload.Response;
import com.example.goToba.payload.ResponseWithMessages;
import com.example.goToba.payload.helper.StaticResponseCode;
import com.example.goToba.payload.helper.StaticResponseMessages;
import com.example.goToba.payload.helper.StaticResponseStatus;
import com.example.goToba.payload.message.MessageResponse;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.implement.WisataServiceImpl;
import com.example.goToba.service.redisService.implement.WisataRedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static java.lang.Boolean.TRUE;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/04/2020.
 */

@CrossOrigin
@RestController
@RequestMapping(WisataControllerRoute.ROUTE_WISATA)
public class WisataController {

    @Autowired
    WisataServiceImpl wisataService;

    @Autowired
    WisataRepo wisataRepo;

    @Autowired
    WisataRedisServiceImpl wisataRedisService;


    @GetMapping(WisataControllerRoute.ROUTE_WISATA_All)
    public Mono<ResponseEntity<?>> findAll() {
        return wisataService.findAll().collectList().
                map(data ->{
                    return  ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK,data));
                });
    }

    @GetMapping(WisataControllerRoute.ROUTE_WISATA_FIND_BY_NAME)
    public ResponseEntity<?> findOne(@PathVariable String name) {
        return ResponseEntity.ok(wisataRepo.findFirstByName(name));
    }

    @GetMapping(WisataControllerRoute.ROUTE_WISATA_FIND_BY_SKU)
    public ResponseEntity<?> findBySku(@PathVariable String sku) {
        if(wisataRedisService.hasKey(sku)){
            return ResponseEntity.ok().body(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK,wisataRedisService.findByKey(sku)));
        }
        return ResponseEntity.ok(new Response(StaticResponseCode.RESPONSE_CODE_SUCCESS, StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK,wisataRepo.findFirstBySkuWisata(sku)));
    }

    @PostMapping(WisataControllerRoute.ROUTE_WISATA_ADD_NEW)
    public ResponseEntity<?> addNew(@RequestBody WisataRequest wisataRequest) {
        wisataService.addWisata(wisataRequest).subscribe();
        return ResponseEntity.ok().body(new ActionResponses(StaticResponseCode.RESPONSE_CODE_SUCCESS ,StaticResponseStatus.RESPONSE_STATUS_SUCCESS_OK, StaticResponseMessages.RESPONSE_MESSAGES_FOR_ADD_WISATA));
    }

    @PutMapping(WisataControllerRoute.ROUTE_WISATA_EDIT_BY_SKU)
    public ResponseEntity<?> updateBySku(@RequestBody WisataRequest request, @PathVariable String sku) {
        wisataService.updateWisata(sku, request).subscribe();
        return ResponseEntity.ok(request);
    }


}
