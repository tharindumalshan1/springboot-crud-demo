package com.example.springcrud.service;

import com.example.springcrud.entity.User;
import com.example.springcrud.exceptions.ResourceNotFoundException;
import com.example.springcrud.exceptions.ResponseError;
import com.example.springcrud.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void shouldSaveUser() {
        User user = new User();
        user.setName("Test Name");

        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        User created = userServiceImpl.saveUser(user);

        assertThat(created.getName()).isSameAs(user.getName());
        verify(userRepository).save(user);
    }

    @Test
    public void shouldReturnAllUsers() {
        List<User> users = new ArrayList();
        users.add(new User());

        given(userRepository.findAll()).willReturn(users);

        List<User> expected = userServiceImpl.getUsers();

        assertEquals(expected, users);
        verify(userRepository).findAll();
    }

    @Test
    public void shouldDeleteUserIfFound(){
        User user = new User();
        user.setName("Test Name");
        user.setEmail("Test Email");
        user.setId(2);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        userServiceImpl.deleteUser(user.getId());
        verify(userRepository).findById(user.getId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void shouldDeleteUserIfNotFound() {
        User user = new User();
        user.setId(15);
        user.setName("Test Name");

        given(userRepository.findById(anyInt())).willReturn(Optional.ofNullable(null));
        userServiceImpl.deleteUser(user.getId());
    }
}