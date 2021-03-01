package com.example.springcrud.service;

import com.example.springcrud.entity.Course;
import com.example.springcrud.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository repository;

    public  List<Course> courseInformation() {
        List<Course> courses = repository.getCourses();
        return courses;
    }
}
