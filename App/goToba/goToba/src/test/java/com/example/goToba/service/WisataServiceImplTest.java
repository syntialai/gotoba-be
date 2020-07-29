package com.example.goToba.service;

import com.example.goToba.model.SequenceWisata;
import com.example.goToba.model.Wisata;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.repository.SequenceWisataRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.elasticService.WisataElasticService;
import com.example.goToba.service.implement.WisataServiceImpl;
import com.example.goToba.service.utils.SkuGenerator;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

/**
 * Created by Sogumontar Hendra Simangunsong on 28/07/2020.
 */
public class WisataServiceImplTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    WisataRepo wisataRepo;

    @Mock
    SequenceWisataRepo sequenceWisataRepo;

    @Mock
    ImageService imageService;

    @Mock
    SkuGenerator skuGenerator;

    @Mock
    WisataElasticService wisataElasticService;

    @InjectMocks
    WisataServiceImpl wisataService;

    @Ignore
    @Test
    public void testAddWisata() {
        Wisata wisata = Wisata.builder().image("image").build();
        WisataRequest wisataRequest= WisataRequest.builder().image("image").createdBy("asd").name("test").build();
        SequenceWisata sequenceWisata = new SequenceWisata();
        StepVerifier.create(wisataService.addWisata(wisataRequest))
                .expectComplete()
                .verify();
        when(skuGenerator.substring("str")).thenReturn("str");
        verify(sequenceWisataRepo).save(sequenceWisata);
        verify(wisataElasticService).save(wisata.toWisata(wisata));
        verify(wisataRepo).save(wisata);
        try {
            verify(imageService).addPicture(wisata.getImage(), "", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        WisataRequest wisataRequest= new WisataRequest();
//        when(wisataRepo.save(wisata)).thenReturn(Mono.just(new Wisata()));
//        assertEquals(wisataService.addWisata(wisataRequest).subscribe(), Mono.just(new Wisata()));
//        verify(wisataRepo).save(wisata);
    }

    @Test
    public void testFindAll(){
        Wisata wisata = new Wisata();
        Flux<Wisata> usersFlux = Flux.just(wisata);
        when(wisataRepo.findAll()).thenReturn(Flux.just(wisata));
        StepVerifier.create(wisataService.findAll())
                .expectNext(wisata)
                .expectComplete()
                .verify();
        verify(wisataRepo).findAll();
    }

    @Test
    public void findBySku(){
        Wisata wisata = new Wisata();
        when(wisataRepo.findFirstBySku("HEND_0001")).thenReturn(Mono.just(wisata));
        assertThat(wisata).isNotNull();
        StepVerifier.create(wisataService.findBySku("HEND_0001"))
                .consumeNextWith(r -> {
                    assertEquals(r ,wisata);
                })
                .expectComplete()
                .verify();
        verify(wisataRepo).findFirstBySku("HEND_0001");
    }
}
