package com.jac.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RatingDTO {
    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;
}
