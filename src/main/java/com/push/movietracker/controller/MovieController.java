package com.push.movietracker.controller;


import com.push.movietracker.model.Movie;
import com.push.movietracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/movies")
    public List<Movie> listOfMovies(){
        return movieService.listOfMovies();
    }

    @RequestMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable int movieId) {
        return movieService.getMovie(movieId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{movieId}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable int movieId) {
        movieService.updateMovie(movieId, movie);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        movieService.deleteMovie(movieId);
    }
}
