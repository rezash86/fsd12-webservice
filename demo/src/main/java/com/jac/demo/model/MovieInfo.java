package com.jac.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieInfo {
    private String movieTitle;
    private Long movieYear;
    private String rating;
}
