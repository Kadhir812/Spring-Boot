package com.example.moviebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviebooking.model.Booking;
import com.example.moviebooking.model.Movie;
import com.example.moviebooking.repository.BookingRepo;

@Service
public class BookingService {
    @Autowired
    BookingRepo repo;

    public Booking saveBooking(Booking b) {
       Booking r = repo.save(b);
       return r;
    }

    public boolean deleteBooking(int bookingId) {
        if (repo.existsById(bookingId)) {
            repo.deleteById(bookingId);
            return true;
        } else {
            return false;
        }
    }
    
    public Booking searchByI(int BookingId) {
       Booking b = repo.findById(BookingId).orElse(null);
       return b;
    }

    public List<Booking> getAll() {
        List<Booking> lis = repo.findAll();
        return lis;
    }
    
    
    public List<Booking> getBookingsByMemberId(int memberId) {
        return repo.findByMemberMemberId(memberId);
    }

    public double calculateTotalBill(int bookingId) {
        Booking booking = repo.findById(bookingId).orElse(null);
        if (booking == null || booking.getMovie() == null) {
            return 0.0;
        }
        return booking.getMovie().getTicketPrice() * booking.getNoOfSeats();
    }


}

