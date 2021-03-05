package com.example.springcrud.service;

import com.example.springcrud.entity.Course;
import com.example.springcrud.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
     CourseRepository courseRepository;


    public  List<Course> courseInformation() {
        List<Course> courses = courseRepository.getCourses();
       // System.out.println(courses);
        return courses;

    }

    @Override
    public int count() {
        return courseRepository.count();
    }

    @Override
    public int save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public int deleteById(Long course_id) {
        return courseRepository.deleteById(course_id);
    }

    @Override
    public int update(Course course){
        return courseRepository.update(course);
    }
}
