package com.example.goToba.service.implement;

import com.example.goToba.service.ImageService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 12/06/2020.
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public byte[] loadImage(String path, String fileName) throws IOException {
        File file = new File("./src/main/resources/static/images/" + path  + "/" + fileName);
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);

            return bytes;
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }
}
