package com.example.goToba.service;

import com.example.goToba.model.Wisata;
import com.example.goToba.payload.request.WisataRequest;
import com.example.goToba.repository.SequenceWisataRepo;
import com.example.goToba.repository.WisataRepo;
import com.example.goToba.service.elasticService.WisataElasticService;
import com.example.goToba.service.implement.WisataServiceImpl;
import com.example.goToba.service.utils.SkuGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;


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

    @Test
    public void testAddWisata() {
//        Wisata wisata= new Wisata(
//                "asd",
//                "asd",
//                "asd",
//                "asd",
//                "asd",
//                "asd",
//                "asd",
//        );
//        WisataRequest wisataRequest= new WisataRequest();
//        when(wisataRepo.save(wisata)).thenReturn(Mono.just(new Wisata()));
//        assertEquals(wisataService.addWisata(wisataRequest).subscribe(), Mono.just(new Wisata()));
//        verify(wisataRepo).save(wisata);
    }
}
