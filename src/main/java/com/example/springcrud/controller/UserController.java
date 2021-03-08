package com.example.springcrud.controller;


import com.example.springcrud.entity.User;
import com.example.springcrud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("/add-users")
    public List<User> addUsers(@RequestBody List<User> users){
        return userService.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/user-by-name/{name}")
    public User findUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/user-by-email/{email}")
    public User findUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public  boolean deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

}

