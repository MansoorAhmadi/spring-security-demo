package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/**")
    public String any() {
        return "Hello World";
    }

    @GetMapping("/secured")
    public String secured(Authentication auth) {
        User user = ((User) auth.getPrincipal());
        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }


}
