package com.rahul.Security.service;

import com.rahul.Security.entity.User;
import com.rahul.Security.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String toekn, User user);
}
