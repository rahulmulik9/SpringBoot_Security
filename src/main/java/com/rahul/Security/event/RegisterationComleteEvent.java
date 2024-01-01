package com.rahul.Security.event;

import com.rahul.Security.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegisterationComleteEvent extends ApplicationEvent {
    private User user;
    private String applicationURL;

    public RegisterationComleteEvent(User user,String applicationurl ) {
        super(user);
        this.user=user;
        this.applicationURL=applicationurl;
    }
}
