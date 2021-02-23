package com.example.springcrud.controller;

import com.example.springcrud.dao.UserDao;
import com.example.springcrud.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserDao dao;


    @PostMapping("/add-users")
    public String addUser(@RequestBody User user){

        dao.save(user);
        return "user added : " + user;
    }

    @GetMapping("/get-Users")
    public List<User> getUsers() {
        return (List<User>) dao.findAll();
    }

    @GetMapping("/get-User/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return  dao.findById(id);
    }

}

