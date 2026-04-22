package com.example.moviebooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviebooking.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

    List<Booking> findByMemberMemberId(int memberId);

  
    
}
