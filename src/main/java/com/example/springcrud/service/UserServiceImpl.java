package com.example.springcrud.service;

import com.example.springcrud.entity.User;
import com.example.springcrud.exceptions.ResourceNotFoundException;
import com.example.springcrud.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

     Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> getUsers(){
        logger.info("Requesting all Users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No user found for userId: " + id));
    }

    @Override
    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    @Override
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean deleteUser(int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid user id: [" + id + "]"));
        userRepository.delete(user);
        return true;
    }



    @Override
    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No user found for UserId: " + user.getId()));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

}