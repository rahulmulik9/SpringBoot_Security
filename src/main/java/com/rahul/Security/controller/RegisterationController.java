package com.rahul.Security.controller;

import com.rahul.Security.entity.User;
import com.rahul.Security.model.UserModel;
import com.rahul.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        User user=userService.registerUser(userModel);
        return null;
    }
}
