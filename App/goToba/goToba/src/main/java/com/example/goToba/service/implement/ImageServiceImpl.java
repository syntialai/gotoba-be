package com.example.goToba.service.implement;

import com.example.goToba.payload.imagePath.ImagePath;
import com.example.goToba.service.ImageService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;

/**
 * Created by Sogumontar Hendra Simangunsong on 12/06/2020.
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public byte[] loadImage(String fileName) throws IOException {
        File file = new File(ImagePath.IMAGE_PATH_ALL + fileName);
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);

            return bytes;
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }


    @Override
    public void addPicture(String base64, String sku, String path) throws IOException {
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper + ImagePath.IMAGE_PATH_GET_IMAGE + path;
        String pict = sku + ImagePath.IMAGE_EXTENSION;
        String partSeparator = ",";
        String encodedImg = "";
        if (base64.contains(partSeparator)) {
            encodedImg = base64.split(partSeparator)[1];
        }
        File file = new File(currentDir + "/" + pict);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] dataBytes = Base64.getMimeDecoder().decode(encodedImg);
            fos.write(dataBytes);
            System.out.println("Image file saved");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
