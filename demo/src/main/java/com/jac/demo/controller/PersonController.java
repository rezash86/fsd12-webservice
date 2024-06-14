package com.jac.demo.controller;

import com.jac.demo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//CTRL + ALT + L
@RestController
public class PersonController {

    @GetMapping("/")
    public String getValue() {
        return "this is my first API !!!!";
    }

    @GetMapping("/person")
    public Person getPerson() {
        return Person
                .builder().firstName("Jill")
                .lastName("Valentine").age(20)
                .build();
    }

    // POST PUT DELETE

    @GetMapping("/person/all")
    public List<Person> getAll(){
        return List.of(
                Person
                .builder().firstName("Jill")
                .lastName("Valentine").age(20)
                .build(),
                Person
                .builder().firstName("Chris")
                .lastName("RefField").age(22)
                .build(),
                Person
                        .builder().firstName("peppa")
                        .lastName("pig").age(28)
                        .build());
    }
}
