package com.example.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviebooking.model.Member;

public interface MemberRepo extends JpaRepository<Member, Integer> {
    
}
