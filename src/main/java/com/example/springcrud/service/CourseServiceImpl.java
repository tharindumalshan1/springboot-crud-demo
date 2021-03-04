package com.example.springcrud.service;

import com.example.springcrud.entity.Course;
import com.example.springcrud.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
     CourseRepository repository;


    public  List<Course> courseInformation() {
        List<Course> courses = repository.getCourses();
       // System.out.println(courses);
        return courses;

    }

    @Override
    public int count() {
        return repository.count();
    }

    @Override
    public int save(Course course) {
        return repository.save(course);
    }

    @Override
    public int deleteById(Long course_id) {
        return repository.deleteById(course_id);
    }

    @Override
    public int update(Course course){
        return repository.update(course);
    }
}
