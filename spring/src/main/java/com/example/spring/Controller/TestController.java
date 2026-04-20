package com.example.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }
}
    

