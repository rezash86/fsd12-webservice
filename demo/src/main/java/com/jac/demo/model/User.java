package com.jac.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private int age;
    private String email;
    private String password;
}
