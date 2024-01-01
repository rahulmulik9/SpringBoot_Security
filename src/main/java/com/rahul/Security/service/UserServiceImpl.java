package com.rahul.Security.service;

import com.rahul.Security.entity.User;
import com.rahul.Security.model.UserModel;
import com.rahul.Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUser(UserModel userModel) {
       User user=new User();
       user.setFirstName(userModel.getFirstName());
       user.setLastName(userModel.getLastName());
       user.setEmail(userModel.getEmail());
       user.setRole("USER");
       user.setPassword(userModel.getPassword());
       return user;
    }
}
