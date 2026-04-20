package com.example.bookmovie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmovie.model.Movie;

@RestController
public class MovieController {

	List<Movie> movie = new ArrayList<>();

	MovieController() {
		movie.add(new Movie(201, "Inception", "Leonardo", 9.0));
		movie.add(new Movie(202, "Interstellar", "Matthew", 8.8));
		movie.add(new Movie(203, "Batman", "Christian", 8.2));
		movie.add(new Movie(204, "Dunkirk", "Tom", 7.9));
	}

	@PostMapping("/movie/add")
	public String addMovie(@RequestBody Movie m) {
		movie.add(m);
		return "movie added";
	}

	@GetMapping("/movie/all")
	List<Movie> getMovie() {
		return movie;
	}

	@GetMapping("/movie/{mid}")
	Movie searchById(@PathVariable int mid) {
		for (Movie m : movie) {
			if (m.getMovieId() == mid) {
				return m;
			}
		}
		return null;
	}

	@PutMapping("/movie/update/{mid}")
	public Movie updateMovie(@PathVariable int mid, @RequestBody Movie updatedMovie) {
		for (Movie m : movie) {
			if (m.getMovieId() == mid) {
				m.setMovieName(updatedMovie.getMovieName());
				m.setHero(updatedMovie.getHero());
				m.setRating(updatedMovie.getRating());
				return m;
			}
		}
		return null;
	}

	@DeleteMapping("/movie/delete/{mid}")
	public Movie deleteMovie(@PathVariable int mid) {
		for (Movie m : movie) {
			if (m.getMovieId() == mid) {
				movie.remove(m);
				return m;
			}
		}
		return null;
	}
}
