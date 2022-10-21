package com.example.bookstore.service;


import com.example.bookstore.entity.User;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User saveUser(User user) {
        User saved = userRepository.save(user);
        return saved;
    }

    @Override
    public User updateUser(User user, int id) {
        User userFound = userRepository.findById(id);
        userFound.setFirstName(user.getFirstName());
        userFound.setLastName(user.getLastName());
        userFound.setRole(user.getRole());
        userFound.setPassword(user.getPassword());

        return userFound;

    }

    @Override
    public User deleteUser(int id) {
        User user = userRepository.findById(id);
        userRepository.deleteById(id);
        return user;

    }
}
