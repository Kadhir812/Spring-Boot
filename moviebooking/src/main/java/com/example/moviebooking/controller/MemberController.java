package com.example.moviebooking.controller;

import com.example.moviebooking.service.MovieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.moviebooking.model.Member;
import com.example.moviebooking.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("/member")
public class MemberController {
    //     Add Member
    // Update Member
    // Delete Member
    // Search Member by ID
    // Show All Members

    private final MovieService movieService;
    @Autowired
    MemberService Service;

    MemberController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public Member create(@RequestBody Member m) {
        return Service.createMember(m);
    }

    @PutMapping("/update/{id}")
    public Member update(@PathVariable int id, @RequestBody Member m) {
        return Service.updateMember(id, m);
    }

    @DeleteMapping("/delete/{id}")
    public Member delete(@PathVariable int id){
        return Service.deleteMember;
    }

    @GetMapping("/search/{id}")
    public Member searchMember(@PathVariable int id) {
        Member b = Service.searchById(id);
        return b;
    }

    @GetMapping("/getAll")
    List<Member> getMembers(){
        List<Member> list = Service.getAllMembers();
        return list;
    }
    

    
    
    


}
