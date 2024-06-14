package org.example;

import lombok.*;

@Getter // it automatically adds getters to all attributes
@Setter // it automatically adds setters to all attributes
@AllArgsConstructor // I have a constructor that has all the attributes
@NoArgsConstructor
@Builder
@ToString
public class Student {
    private String firstname;
    private String lastName;
    private Address address;
    private int age;
    private String[] hobbies;
    private boolean isRegistered;


}
