package com.example.springcrud.service;

import com.example.springcrud.entity.User;
import com.example.springcrud.exceptions.ResourceNotFoundException;
import com.example.springcrud.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

     Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;


    public String hello(String name){
        return String.format("Hello %s",name);
    }

    @Override
    public User saveUser(User user){
        logger.error("Test Logger");
        return repository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    @Override
    public List<User> getUsers(){
        logger.info("Requesting all Users");
        return repository.findAll();
    }

    @Override
    public User getUserById(int id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No user found for userId: " + id));
    }

    @Override
    public User getUserByName(String name){
        return repository.findByName(name);
    }

    @Override
    public User getUserByEmail(String email){
        return repository.findByEmail(email);
    }

    @Override
    public boolean deleteUser(int id){
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid user id: [" + id + "]"));
        repository.delete(user);
        return true;
    }



    @Override
    public User updateUser(User user){
        User existingUser = repository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No user found for UserId: " + user.getId()));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return repository.save(existingUser);
    }

}