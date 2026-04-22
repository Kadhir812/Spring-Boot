package com.example.moviebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviebooking.model.Movie;
import com.example.moviebooking.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    
    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

   
    @PutMapping("/update/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) {
         Movie b = movieService.updateMovie(id, movie);
         return b;
    }

    @DeleteMapping("/delete/{id}")
    public Movie deleteMovie(@PathVariable int id) {
        Movie b = movieService.deleteMovie(id);
        return b;
    }

 
    @GetMapping("/search/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/search/{language}")
    public Movie getMovieByLanguage(@PathVariable String language) {
        return movieService.getMovieByLang(language);
    }

    @GetMapping("/search/{genre}")
    public Movie getMovieByGenre(@PathVariable String genre) {
        return movieService.getMovieByGen(genre);
    }

   
    @GetMapping
    public List<Movie> getAllMovies() {
        List<Movie> lis = movieService.getAllMovies();
        return lis;
    }
}
