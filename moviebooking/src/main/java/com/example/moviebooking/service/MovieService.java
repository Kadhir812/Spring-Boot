package com.example.moviebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviebooking.model.Movie;
import com.example.moviebooking.repository.MovieRepo;

@Service
public class MovieService {
    @Autowired
    MovieRepo repo;

    public Movie addMovie(Movie movie) {
        return repo.save(movie);
    }

    public Movie updateMovie(int id, Movie movie) {
        Movie existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setMovieName(movie.getMovieName());
            existing.setLanguage(movie.getLanguage());
            existing.setGenre(movie.getGenre());
            existing.setDuration(movie.getDuration());
            existing.setTicketPrice(movie.getTicketPrice());
           
            return repo.save(existing);
        }
        return null;
    }

    public Movie deleteMovie(int id) {
        Movie movie = repo.findById(id).orElse(null);
        if (movie != null) {
            repo.deleteById(id);
        }
        return movie;
    }

    public Movie getMovieById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Movie getMovieByLang(String language) {
        return repo.findByLanguage(language);
    }

    public Movie getMovieByGen(String genre) {
        return repo.findByGenre(genre);
    }

    public List<Movie> getAllMovies() {
        return repo.findAll();
    }
}
