package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

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

//        String[] hobbies = {"music","movie"};
        Student student = Student.builder()
                .firstname("Reza")
                .lastName("shalchi")
                .age(20)
                //.hobbies(hobbies)
                .hobbies(new String[]{"music","movie"})
                .address(Address.builder().StreetNumber(20).streetName("Rene levesque").build())
                .isRegistered(true)
                .build();
        System.out.println(mapper.writeValueAsString(student));

        String studentJson = "{\"firstname\":\"Reza\",\"lastName\":\"shalchi\",\"address\":{\"streetName\":\"Rene levesque\"," +
                "\"streetNumber\":20},\"age\":20,\"hobbies\":[\"music\",\"movie\"],\"registered\":true}";
        System.out.println(mapper.readValue(studentJson, Student.class));
    }
}