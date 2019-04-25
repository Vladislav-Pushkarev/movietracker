package com.push.movietracker.service;

import com.push.movietracker.repository.MovieRepository;
import com.push.movietracker.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Movie getMovie(int movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    public void updateMovie(int movieId, Movie movie) {
       movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll()
                .forEach(movies::add);
        return movies;
    }
}
