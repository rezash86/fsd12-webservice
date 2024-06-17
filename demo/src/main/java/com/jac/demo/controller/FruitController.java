package com.jac.demo.controller;

import com.jac.demo.model.Color;
import com.jac.demo.model.Fruit;
import com.jac.demo.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    //List.of -> is unmodifiable so I cannot run some functions like create a new one or update the exiting ones
    //I used arrayList and I passed the list.of into that as a constructor
    List<Fruit> fruitList = new ArrayList<>(List.of(
            Fruit.builder().name("Apple").color(Color.RED).pricePerKilo(100).build(),
            Fruit.builder().name("Orange").color(Color.ORANGE).pricePerKilo(100).build(),
            Fruit.builder().name("Cucumber").color(Color.GREEN).pricePerKilo(100).build()
            ));

    @GetMapping("/{name}")
    public Fruit getOneByName(@PathVariable String name){
        Optional<Fruit> first = fruitList.stream().filter(fr -> fr.getName().equals(name)).findFirst();
        return first.orElse(null);
    }

    @GetMapping("/")
    public List<Fruit> getAll(){ // Using interface classes in the description or output
        return this.fruitList;
    }

    @PostMapping("/")
    public void createFruit(@RequestBody Fruit fruit){
        this.fruitList.add(fruit);
    }

    @PutMapping("/{name}")
    public void updateFruit(@PathVariable String name, @RequestBody Fruit fruit){
        Optional<Fruit> first = fruitList.stream().filter(fr -> fr.getName().equals(name)).findFirst();
        if(first.isPresent()){
            Fruit toBeUpdated = first.get();
            toBeUpdated.setColor(fruit.getColor());
            toBeUpdated.setName(fruit.getName());
            toBeUpdated.setPricePerKilo(fruit.getPricePerKilo());

        }
    }

    @DeleteMapping("/{name}")
    public void deleteByName(@PathVariable String name){
        Optional<Fruit> first = fruitList.stream().filter(fr -> fr.getName().equals(name)).findFirst();
        first.ifPresent(fruit -> this.fruitList.remove(fruit));
    }
}
