package com.rahul.Security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeBro {
    @GetMapping("/welcome")
    public String sayWelcome(){
        return "Welcome to Spring Application with Security";
    }

    //when you start the application the password is in the console.
    //username  is by default user
}
