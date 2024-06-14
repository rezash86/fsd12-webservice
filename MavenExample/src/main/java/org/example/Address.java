package org.example;

import lombok.*;

@Getter // it automatically adds getters to all attributes
@Setter // it automatically adds setters to all attributes
@AllArgsConstructor // I have a constructor that has all the attributes
@NoArgsConstructor
@Builder
public class Address {
    private String streetName;
    private int StreetNumber;
}
