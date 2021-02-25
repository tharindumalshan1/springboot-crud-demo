package com.example.springcrud.controller;


import java.util.List;

import com.example.springcrud.entity.Course;
import com.example.springcrud.repository.CourseRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {


    @Autowired
    public CourseRepository courseRepository;

    @RequestMapping("/get-courses")
    public List<Course> courseInformation() {
        List<Course> courses = courseRepository.isData();
        return courses;
    }
}