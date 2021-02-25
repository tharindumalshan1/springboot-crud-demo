package com.example.springcrud.service;

import com.example.springcrud.entity.User;
import com.example.springcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
//    @Autowired
//    public UserService(UserRepository repository) {
//        this.repository = repository;
//    }

   @Autowired
    private UserRepository repository;

    //Post Methods

    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    //get methods
    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    public User getUserByName(String name){
        return repository.findByName(name);
    }

    public User getUserByEmail(String email){
        return repository.findByEmail(email);
    }

    //Delete method
    public String deleteUser(int id){
        repository.deleteById(id);
        return  "User Deleted !!!! " + id;
    }

    //Update method
    public User updateUser(User user){
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return repository.save(existingUser);
    }

}
