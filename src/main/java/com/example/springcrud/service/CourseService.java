package com.example.springcrud.service;

import com.example.springcrud.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    /**
     * Returns the list of all available courses
     * This will return an empty list if no users are available
     * @return  list of courses
     */
    List<Course> courseInformation();
}
