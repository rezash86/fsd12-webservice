package com.example.test.controller;

import com.example.test.model.Animal;
import com.example.test.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AnimalController {

    @Autowired
    AnimalService service;

    @GetMapping("/animal")
    public Animal getRandomDog(){
        try {
            return service.getDog();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/animal", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadRandomPic(@RequestParam("file") MultipartFile file){
        try {
            service.uploadAnimalPicture(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
