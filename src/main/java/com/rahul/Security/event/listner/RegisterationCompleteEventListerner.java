package com.rahul.Security.event.listner;

import com.rahul.Security.entity.User;
import com.rahul.Security.event.RegisterationComleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegisterationCompleteEventListerner implements ApplicationListener<RegisterationComleteEvent> {
    @Override
    public void onApplicationEvent(RegisterationComleteEvent event) {
        //create verification token with user
        User user = event.getUser();
        String toekn = UUID.randomUUID().toString();

        //send mail to user

    }
}
