package com.rahul.Security.event;

import com.rahul.Security.entity.User;
import org.springframework.context.ApplicationEvent;

public class RegisterationComleteEvent extends ApplicationEvent {
    private User user;
    private String applicationURL;

    public RegisterationComleteEvent(User user,String applicationurl ) {
        super(user);
        this.user=user;
        this.applicationURL=applicationurl;
    }
}
