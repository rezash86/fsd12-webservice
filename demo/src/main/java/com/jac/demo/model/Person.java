package com.jac.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data //acts the same as @GETTER and @Setter
@Builder
@ToString
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
