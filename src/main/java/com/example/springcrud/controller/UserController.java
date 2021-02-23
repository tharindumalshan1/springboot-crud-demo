package com.example.springcrud.controller;

import com.example.springcrud.dao.UserDao;
import com.example.springcrud.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserDao dao;


    @PostMapping("/addUsers")
    public String addUser(@RequestBody User user){

       // dao.save(user);
        dao.save(user);
        return "user added : " + user;
    }

    @GetMapping("/getUser")
    public List<User> getUsers() {
        return (List<User>) dao.findAll();
    }
}

