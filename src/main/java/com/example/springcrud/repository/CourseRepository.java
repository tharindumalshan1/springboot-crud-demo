package com.example.springcrud.repository;

import com.example.springcrud.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Repository
public class CourseRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL = "select * from course";

    public List<Course> getCourses() {

        List<Course> courses = new ArrayList<Course>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String, Object> row : rows)
        {
            Course course = new Course();
            course.setCourse_id((Long)row.get("course_id"));
            course.setCourse_name((String)row.get("course_name"));
            course.setContent((String)row.get("content"));

            courses.add(course);
        }

        return courses;
    }
}