package com.jac.demo.service;

import com.jac.demo.adapter.OMDBApiAdapter;
import com.jac.demo.dto.MovieInfoDTO;
import com.jac.demo.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service // known as a component but you are going to use it as a service
public class MovieService {
    @Autowired
    OMDBApiAdapter adapter;

    public MovieInfo getMovieInfo(String title){
        var movieInfoDTO = adapter.getMovieInfo(title);
        return MovieInfo.builder()
                .movieTitle(movieInfoDTO.getTitle())
                .movieYear(Long.parseLong(movieInfoDTO.getYear()))
                .rating(movieInfoDTO.getRated())
                .build();
    }
}
