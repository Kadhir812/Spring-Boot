package com.example.moviebooking.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer memberId;
    String name;
    String email;
    Integer phoneNo;
    String city;
    String password;
   
    @OneToMany(mappedBy = "member")
    @JsonManagedReference("member-bookings")
    List<Booking> bookings;
        public List<Booking> getBookings() {
            return bookings;
        }

        public void setBookings(List<Booking> bookings) {
            this.bookings = bookings;
        }
    public Member() {
    }

    public Member(Integer memberId, String name, String email, Integer phoneNo, String city, String password) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.city = city;
        this.password = password;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
                + ", city=" + city + ", password=" + password + "]";
    }

    

    

    
}
