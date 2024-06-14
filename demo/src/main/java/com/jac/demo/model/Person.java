package com.jac.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data //acts the same as @GETTER and @Setter
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}
