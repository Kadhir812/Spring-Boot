package com.example.moviebooking.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer movieId; 
    String movieName;
    String language;
    String genre;
    String duration;
    Double ticketPrice;
    
    @OneToMany(mappedBy = "movie")
    @JsonManagedReference("movie-bookings")
    List<Booking> bookings;
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Movie() {
    }

    public Movie(Integer movieId, String movieName, String language, String genre, String duration, Double ticketPrice) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.language = language;
        this.genre = genre;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
    }

    
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public Double getTicketPrice() {
        return ticketPrice;
    }
    
    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    
    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", genre=" + genre
                + ", duration=" + duration + ", ticketPrice=" + ticketPrice + "]";
    }
    
    
}
