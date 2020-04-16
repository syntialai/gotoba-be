package com.example.goToba.controller;

import com.example.goToba.controller.route.WisataControllerRoute;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.ApiResponse;
import com.example.goToba.payload.AuthenticationResponse;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.implement.WisataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @PostMapping(WisataControllerRoute.ROUTE_WISATA_ADD_NEW)
    public ResponseEntity<?> addNew(@RequestBody WisataRequest wisataRequest){
        wisataService.addWisata(wisataRequest);
        return ResponseEntity.ok(new AuthenticationResponse("test","200","OK","Tambah data wisata sukses"));
    }
    @GetMapping(WisataControllerRoute.ROUTE_WISATA_All)
    public Flux<Wisata> findAll(){
        return wisataService.findAll();
    }

    @GetMapping("/find/{name}")
    public Mono<ResponseEntity<String>> findOne(@PathVariable String name){

        return wisataRepo.findFirstByName(name).
                flatMap(b ->{
                    return Mono.just(ResponseEntity.ok().body("ada data"));
                }).switchIfEmpty(Mono.just(ResponseEntity.badRequest().body("Tidak ada bro")));
    }

    @GetMapping("/ex/{name}")
    public Mono<Boolean> check(@PathVariable String name){
        return wisataRepo.existsByName(name)
                .flatMap(b->{
                   return Mono.just(Boolean.TRUE);
                })
                .switchIfEmpty(
                        Mono.just(Boolean.FALSE)
                );
    }


}
