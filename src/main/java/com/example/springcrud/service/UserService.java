package com.example.springcrud.service;

import com.example.springcrud.entity.User;
import org.springframework.stereotype.Service;
import com.example.springcrud.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public interface UserService {

    /**
     * Creates a new user
     * @param user the new User to be created
     * @return the created user
     */
     User saveUser(User user);

    /**
     * Creates new user List
     * @param users the new User to be created
     * @return the created List of users
     */
     List<User> saveUsers(List<User> users);

    /**
     * Returns the list of all available users
     * This will return an empty list if no users are available
     * @return  list of users
     */
     List<User> getUsers();

    /**
     * Returns the Users with the given UserId.
     * @param  id the ID of the app
     * @return  User with the given UserId
     */
     User getUserById(int id);

    /**
     * Returns the Users with the given UserName.
     * @param  name the Name of the app
     * @return  User with the given UserName
     */
     User getUserByName(String name);

    /**
     * Returns the Users with the given Email.
     * @param  email the Name of the app
     * @return  User with the given Email
     */
    User getUserByEmail(String email);

    /**
     * Deletes the user with the given user Id
     * @param id the Id of the user to delete
     * @return 'User Deleted' if a was deleted successfully
     */
    String deleteUser(int id);

    /**
     * Modify the details of an existing users
     * Method will always return the updated users after a successful operation
     * @param user the User being modified
     * @return  the users with updated details
     */
     User updateUser(User user);

}
