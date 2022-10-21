package com.example.bookstore.controller;

import com.example.bookstore.entity.User;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/getUsers")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }




    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping(value = "/user")
    public ResponseEntity<?> deleteById(@RequestParam(value="id") int id){
        User deleted = userService.deleteUser(id);

        return ResponseEntity.ok("user is deleted !");

    }

    @PutMapping(value ="/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable int id){
        User userFound = userService.updateUser(user,id);
        if(userFound == null){
            return ResponseEntity.ok("User not found, FAILED !");
        }else{
            return ResponseEntity.ok(userFound);
        }
    }
}
