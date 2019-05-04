package com.push.movietracker.controller;


import com.push.movietracker.model.Movie;
import com.push.movietracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, value="/movie/{movieId}")
    public String  getMovie(@PathVariable int movieId, Model model) {
        model.addAttribute("movie", movieService.getMovie(movieId));

        return "movie";
    }

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Integer movieId, HttpServletResponse response, HttpServletRequest request) throws IOException{

        Movie movie = movieService.getMovie(movieId);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(movie.getImage());

        response.getOutputStream().close();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/addMovie")
    public String addMovie(@ModelAttribute("movie") Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/movieList";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addMovie/{movieId}")
    public String updateMovie(@ModelAttribute Movie movie, @PathVariable int movieId) {
        movieService.updateMovie(movieId, movie);
        return "redirect:/movieList";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addImage/{movieId}")
    public String uploadImage(@RequestParam("imageFile") MultipartFile multipartFile, @PathVariable int movieId) throws IOException {
        Movie movie = movieService.getMovie(movieId);
        movie.setImage(multipartFile.getBytes());
        movieService.updateMovie(movieId, movie);

        return  "redirect:/movieList";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movie/{movieId}")
    public String deleteMovie(@PathVariable int movieId){
        movieService.deleteMovie(movieId);
        return "redirect:/movieList";
    }

    @RequestMapping(method = RequestMethod.GET, value = { "/movieList"})
    public String viewMovieList(Model model) {

        model.addAttribute("movies", movieService.getAllMovies());

        return "movieList";
    }
}
