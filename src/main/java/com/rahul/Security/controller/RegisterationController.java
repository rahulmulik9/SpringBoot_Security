package com.rahul.Security.controller;

import com.rahul.Security.entity.User;
import com.rahul.Security.event.RegisterationComleteEvent;
import com.rahul.Security.model.UserModel;
import com.rahul.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterationController {

    @Autowired
    private UserService userService;

    //by default user is disabled , so enable it we create one event
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        User user=userService.registerUser(userModel);
        //we have to pass application event. SO we want to create it
        //created EventPackage => java class registerCOmpleterEVent
        publisher.publishEvent(new RegisterationComleteEvent(user,"Url"));
        return "Success";
    }



}
