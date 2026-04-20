package com.example.spring2.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring2.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class Control {
    List<Student> users = new ArrayList<>();

    Control(){
        users.add(new Student(101,"Ajay",90.0));
		users.add(new Student(102,"Jatin",20.0));
 
		users.add(new Student(103,"Nitin",80));
 
		users.add(new Student(104,"Kavita",70));
    }


    @GetMapping("showAll")
    List<Student> showUsers() {
        return users;
    }

    @GetMapping("/search/{rno}")
    Student searchRoll(@PathVariable int rno) {
       for (Student s : users) {
            if (s.getRoll() == rno) {
                return s;
            }
        }

        return null;
    }

    @GetMapping("/search/name/{name}")
    Student searchByName(@PathVariable String name) {
        for (Student s : users) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }

        return null;
    }


    @PostMapping("/saveData")
    public String postMethodName(@RequestBody Student s) {
        //TODO: process POST request
        users.add(s);
        return "saveData";
    }

    @PutMapping("/update/{rno}/{marks}")
    public Student updateMarks(@PathVariable int rno, @PathVariable double marks) {
        for (Student s : users) {
            if (s.getRoll() == rno) {
                s.setMarks(marks);
                return s;
            }
        }

        return null;
    }

    @DeleteMapping("/delete/{rno}")
    public Student deleteUser(@PathVariable int rno) {
        for (Student s : users) {
            if (s.getRoll() == rno) {
                users.remove(s);
                return s;
            }
        }

        return null;
    }

}
