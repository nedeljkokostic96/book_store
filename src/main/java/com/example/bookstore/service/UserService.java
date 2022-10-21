package com.example.bookstore.service;

import com.example.bookstore.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();

    User saveUser(User user);

    User updateUser(User user,int id);

    User deleteUser(int id);
}
