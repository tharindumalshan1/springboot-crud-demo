package com.example.springcrud.controller;


import java.util.List;

import com.example.springcrud.entity.Course;
import com.example.springcrud.entity.User;
import com.example.springcrud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/get-courses")
    public List<Course> courseInfor() {
        return courseService.courseInformation();
    }

    @RequestMapping("/get-count")
    public int getcount() {
        return courseService.count();
    }

    @PostMapping("/add-course")
    public int addCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @DeleteMapping("/delete-course/{course_id}")
    public int deleteCourse(@PathVariable Long course_id){
        return courseService.deleteById(course_id);
    }

    @PutMapping("/update-course")
    public int updateCourse(@RequestBody Course course){
        return courseService.update(course);
    }

}