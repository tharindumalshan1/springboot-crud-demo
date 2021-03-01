package com.example.springcrud.controller;


import java.util.List;

import com.example.springcrud.entity.Course;
import com.example.springcrud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/get-courses")
    public List<Course> courseInfor() {
        return courseService.courseInformation();
    }
}