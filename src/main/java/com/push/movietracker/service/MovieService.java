package com.push.movietracker.service;

import com.push.movietracker.model.Movie;

import java.util.List;

public interface MovieService {

    void addMovie(Movie movie);

    Movie getMovie(int movieId);

    void updateMovie(int movieId, Movie movie);

    void deleteMovie(int movieId);

    List<Movie> getAllMovies();




}
