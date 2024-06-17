package com.jac.demo.controller;

import com.jac.demo.dto.MovieInfoDTO;
import com.jac.demo.model.MovieInfo;
import com.jac.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // is a kind of component
@RequestMapping("/movie")
public class MovieController {
    //springify
//    OMDBApiAdapter adapter = new OMDBApiAdapter();
    @Autowired //is a keyword for inversion of control , here u use dependency injection
    MovieService service;

    @GetMapping("/{title}")
    public MovieInfo getMovieInfo(@PathVariable String title){
        return service.getMovieInfo(title);
    }
}
