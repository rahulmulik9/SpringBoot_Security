package com.rahul.Security.service;

import com.rahul.Security.entity.User;
import com.rahul.Security.model.UserModel;
import com.rahul.Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(UserModel userModel) {
       User user=new User();
       //copying object
       user.setFirstName(userModel.getFirstName());
       user.setLastName(userModel.getLastName());
       user.setEmail(userModel.getEmail());
       user.setRole("USER");
       user.setPassword(passwordEncoder.encode(userModel.getPassword()));
       //saving user
        userRepository.save(user);
       return user;
    }
}
