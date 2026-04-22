package com.example.moviebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviebooking.model.Booking;
import com.example.moviebooking.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/booking")
public class BookingController {
    //     Book Ticket
    // Cancel Booking
    // Search Booking by ID
    // Show All Bookings
    // Show Bookings by Member ID

    @Autowired
    BookingService Service;

    //add booking
    @PostMapping("/add")
    public Booking addBooking(@RequestBody Booking B) {
       Booking r = Service.saveBooking(B);
       return r;
    }

    // cancel booking
    @PostMapping("/cancel")
    public Booking cancelBooking(@RequestBody int bookingId) {
         Booking booking = Service.searchByI(bookingId);
         boolean deleted = Service.deleteBooking(bookingId);
         if (deleted) {
             return booking;
         } else {
             return null;
         }
    }

    //search booking by id
    @GetMapping("/search/{id}")
    public Booking searchById(@PathVariable int id) {
        Booking b = Service.searchByI(id);
        return b;
    }

    //show all bookings
    @GetMapping("/getAll")
    List<Booking> getBookings(){
        List<Booking> list = Service.getAll();
        return list;
    }
    
    // Show bookings by memberId
    @GetMapping("/member/{memberId}")
    public List<Booking> getBookingsByMemberId(@PathVariable int memberId) {
        return Service.getBookingsByMemberId(memberId);
    }

    // Calculate total bill for a booking
    @GetMapping("/total-bill/{bookingId}")
    public double getTotalBill(@PathVariable int bookingId) {
        return Service.calculateTotalBill(bookingId);
    }

}
