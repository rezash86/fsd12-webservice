package com.jac.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MovieInfoDTO {
    //Title -> case sensitivity IS important
    @JsonProperty("Title")
    private String title; //Title with capital letter is wrong in JAVA

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Ratings")
    private List<RatingDTO> ratings;
}
