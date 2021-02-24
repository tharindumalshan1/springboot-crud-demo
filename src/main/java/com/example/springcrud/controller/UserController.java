package com.example.springcrud.controller;


import com.example.springcrud.entity.User;
import com.example.springcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("user/{id}")
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }

}

