package com.jac.demo.controller;

import com.jac.demo.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//CTRL + ALT + L
@RestController
@RequestMapping("/person") //I needed this one to include the path for all the methods
public class PersonController {

//    @GetMapping("/")
//    public String getValue() {
//        return "this is my first API !!!!";
//    }

    @GetMapping("/")
    public Person getPerson() {
        return Person
                .builder().firstName("Jill")
                .lastName("Valentine").age(20)
                .build();
    }

    @GetMapping("/all")
    public List<Person> getAll(){
        return List.of(
                Person
                .builder().firstName("Jill")
                .lastName("Valentine").age(20)
                .build(),
                Person
                .builder().firstName("Chris")
                .lastName("Redfield").age(22)
                .build(),
                Person
                        .builder().firstName("peppa")
                        .lastName("pig").age(28)
                        .build());
    }

    @PostMapping("/")
    public void createPerson(@RequestBody Person person){
        System.out.println(person);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable long id, @RequestBody Person person){
        System.out.println(person);
        System.out.println(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable long id){
        System.out.println(id);
    }
}
