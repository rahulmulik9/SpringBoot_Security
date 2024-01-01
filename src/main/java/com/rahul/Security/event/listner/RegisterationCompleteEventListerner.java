package com.rahul.Security.event.listner;

import com.rahul.Security.entity.User;
import com.rahul.Security.event.RegisterationComleteEvent;
import com.rahul.Security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegisterationCompleteEventListerner implements ApplicationListener<RegisterationComleteEvent> {
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegisterationComleteEvent event) {
        //create verification token with user
        User user = event.getUser();
        String toekn = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(toekn, user);
        //send mail to user (here we are miking the url method ...do reasearch and implement it )
        String url=event.getApplicationURL()+"Verify Registeration"+toekn;
        log.info("Click the link to verify your account ",url);

    }
}
