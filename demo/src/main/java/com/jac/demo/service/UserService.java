package com.jac.demo.service;

import com.jac.demo.model.User;
import com.jac.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public Long saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
