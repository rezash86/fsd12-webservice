package com.jac.demo.controller;

import com.jac.demo.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//CTRL + ALT + L
@RestController
@RequestMapping("/person") //I needed this one to include the path for all the methods
public class PersonController {
    List<Person> peopleList = new ArrayList<>(List.of(
            Person
                    .builder()
                    .id(1)
                    .firstName("Jill")
                    .lastName("Valentine").age(20)
                    .build(),
            Person
                    .builder()
                    .id(2)
                    .firstName("Chris")
                    .lastName("Redfield").age(22)
                    .build(),
            Person
                    .builder()
                    .id(3)
                    .firstName("peppa")
                    .lastName("pig").age(28)
                    .build()));

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


    @GetMapping("/name")
    public Person getPersonByName(@PathVariable String name) {
        Optional<Person> optionalPerson = peopleList.stream().filter(person -> person.getFirstName().equals(name)).findFirst();
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }

        return null;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable long id) {
        //old approach
//        for(Person person : peopleList){
//            if(person.getId() == id){
//                return person;
//            }
//        }
        //new approach
        //JAVA 8 !!! Mandatory
        Optional<Person> optionalPerson = peopleList.stream().filter(person -> person.getId() == id).findFirst();
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }
        return null;
    }
    @GetMapping("/all")
    public List<Person> getAll(@RequestParam(required = false) Long age, @RequestParam(required = false) String fname){
        if(age != null){
            return peopleList.stream().filter(person -> person.getAge()> age)
                    .filter(person -> person.getFirstName().startsWith(fname))
                    .collect(Collectors.toList());
        }

        return this.peopleList;
    }

    @PostMapping("/")
    public void createPerson(@RequestBody Person person){
        //adding a logic to provide id
        int id = peopleList.size() + 1;
        person.setId(id);
        peopleList.add(person);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable long id, @RequestBody Person person){
        Optional<Person> optionalPerson = peopleList.stream().filter(p -> p.getId() == id).findFirst();
        if(optionalPerson.isPresent()){
            Person found = optionalPerson.get();
            found.setFirstName(person.getFirstName());
            found.setLastName(person.getLastName());
            found.setAge(person.getAge());
        }
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable long id){
        Optional<Person> optionalPerson = peopleList.stream().filter(p -> p.getId() == id).findFirst();
        if(optionalPerson.isPresent()){
            peopleList.remove(optionalPerson.get());
        }

    }
}
