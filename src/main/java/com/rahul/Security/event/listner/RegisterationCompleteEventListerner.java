package com.rahul.Security.event.listner;

import com.rahul.Security.entity.User;
import com.rahul.Security.event.RegisterationComleteEvent;
import com.rahul.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegisterationCompleteEventListerner implements ApplicationListener<RegisterationComleteEvent> {
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegisterationComleteEvent event) {
        //create verification token with user
        User user = event.getUser();
        String toekn = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(toekn, user);
        //send mail to user

    }
}
