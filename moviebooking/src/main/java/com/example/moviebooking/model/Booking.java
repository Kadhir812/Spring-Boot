
package com.example.moviebooking.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookingId;
    Integer bookingDate;
    Integer noOfSeats;
    Double totalAmount;
    String bookingStatus;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonBackReference("member-bookings")
    Member member;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference("movie-bookings")
    Movie movie;
    
    public Booking() {
    }

    public Booking(Integer bookingId, Integer bookingDate, Integer noOfSeats, Double totalAmount, String bookingStatus,
            Member member, Movie movie) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.noOfSeats = noOfSeats;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
        this.member = member;
        this.movie = movie;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Integer bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", noOfSeats=" + noOfSeats
            + ", totalAmount=" + totalAmount + ", bookingStatus=" + bookingStatus + ", member=" + (member != null ? member.getMemberId() : null)
            + ", movie=" + (movie != null ? movie.getMovieId() : null) + "]";
    }

    
    
}
