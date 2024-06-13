package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Car car = new Car("Tesla", 2000, 20);

        //I would like to convert this object into JSON
        System.out.println("JAVA -> JSON");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(car));

        System.out.println("JSON -> JAVA");
        String jsonString = "{\"make\":\"Honda\",\"productionYear\":2017,\"engineSize\":25.0}";
        Car deserializedCar = mapper.readValue(jsonString, Car.class);
        System.out.println(deserializedCar);
    }
}