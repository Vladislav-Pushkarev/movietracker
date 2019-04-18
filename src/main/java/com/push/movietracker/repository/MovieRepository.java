package com.push.movietracker.repository;

import com.push.movietracker.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer>{

}
