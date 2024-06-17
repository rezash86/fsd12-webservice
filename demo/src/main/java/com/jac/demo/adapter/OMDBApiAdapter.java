package com.jac.demo.adapter;

import com.jac.demo.dto.MovieInfoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class OMDBApiAdapter {

    @Value("${omdbapi.url}")
    private String apiUrl;
    @Value("${omdbapi.key}")
    private String apiKey;

    /**
     * this method is going to be used for receiving information form omdbapi
     */
    public MovieInfoDTO getMovieInfo(final String movieTitle) {
        //for calling another REST api we use RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        final String route = apiUrl.concat("?apikey={key}&t={title}");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("key", apiKey);
        parameters.put("title", movieTitle);

        MovieInfoDTO movieInfo = restTemplate.getForObject(route, MovieInfoDTO.class, parameters);

        return movieInfo;
    }
}
