package com.example.moviebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviebooking.model.Member;
import com.example.moviebooking.repository.MemberRepo;

@Service
public class MemberService {
    @Autowired
    MemberRepo repo;
    public Member deleteMember;

    public Member createMember(Member m) {
        return repo.save(m);
    }

    public Member updateMember(int memberId, Member m) {
        Member e = repo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        e.setName(m.getName());
        e.setEmail(m.getEmail());
        e.setPhoneNo(m.getPhoneNo());
        e.setCity(m.getCity());
        e.setPassword(m.getPassword());

        return repo.save(e);
    }

    public Member deleteMember(int memberId){
        repo.deleteById(memberId);
        return deleteMember;
    }

    public Member searchById(int memberId) {
       Member b = repo.findById(memberId).orElse(null);
       return b;
    }
    
    public List<Member> getAllMembers() {
        return repo.findAll();
    }
}
