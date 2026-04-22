package com.example.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviebooking.model.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

    Movie findByLanguage(String language);

    Movie findByGenre(String genre);
    
}
