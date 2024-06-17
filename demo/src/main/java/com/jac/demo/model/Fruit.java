package com.jac.demo.model;

import lombok.*;

/**
 * I would like you to create an aPi form scratch
 * it has FruitController and Fruit model
 * that give me GET ALL, GET BY NAME, add , UPDATE, DELETE  a fruit
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Fruit {
    private String name;
    //Try to use ENUM -> RED, GREEN, BLUE, ORANGE
    private Color color;
    private double pricePerKilo;
}
