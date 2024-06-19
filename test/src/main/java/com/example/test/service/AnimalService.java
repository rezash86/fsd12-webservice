package com.example.test.service;

import com.example.test.adapter.AnimalAdapter;
import com.example.test.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class AnimalService {

    @Autowired
    AnimalAdapter animalAdapter ;

    public Animal getDog() throws IOException {
        var dog = animalAdapter.callDogApi();
        String urlAsString = dog.getMessage();
        String[] urlAsArray = urlAsString.split("/"); //it is used to fetch the name of the file

        URL url = new URL(dog.getMessage());
        InputStream in = url.openStream();

        Files.copy(in, Paths.get("src\\main\\resources\\download\\" + urlAsArray[urlAsArray.length- 1]));
        return dog;
    }

    public void uploadAnimalPicture(MultipartFile file) throws IOException {
        File convertFile = new File("src\\main\\resources\\upload\\" + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
    }
}
