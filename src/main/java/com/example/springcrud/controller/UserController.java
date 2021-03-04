package com.example.springcrud.controller;


import com.example.springcrud.entity.User;
import com.example.springcrud.exceptions.ResourceNotFoundException;
import com.example.springcrud.service.UserService;
import com.example.springcrud.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        logger.info("Adding new User [{}] " , user);
        return service.saveUser(user);
    }

    @PostMapping("/add-users")
    public List<User> addUsers(@RequestBody List<User> users){
        return service.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id){
        logger.error("user Id not found error [{}]" ,  id);
        return service.getUserById(id);
    }

    @GetMapping("/user-by-name/{name}")
    public User findUserByName(@PathVariable String name){
        logger.debug("Request" , name);
        return service.getUserByName(name);
    }

    @GetMapping("/user-by-email/{email}")
    public User findUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        logger.info("update user : [{}]" , user);
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public  boolean deleteUser(@PathVariable int id){
        logger.info("Deleting user : [{}]", id);
        return service.deleteUser(id);
    }

}

