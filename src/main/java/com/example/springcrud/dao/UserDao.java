package com.example.springcrud.dao;

import com.example.springcrud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

}