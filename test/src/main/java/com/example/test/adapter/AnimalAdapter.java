package com.example.test.adapter;

import com.example.test.model.Animal;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AnimalAdapter {

    public Animal callDogApi(){
        String url = "https://dog.ceo/api/breeds/image/random";
        RestTemplate restTemplate = new RestTemplate();
        Animal dog = restTemplate.getForObject(url, Animal.class);
        return dog;
    }
}
