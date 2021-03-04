package com.example.springcrud.repository;

import com.example.springcrud.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
@Primary
@Configuration
@PropertySource("classpath:queries.properties")
public class CourseRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${course.FindAll}")
    String findCourses;

    @Value("${course.Count}")
    String CountCourses;

    @Value("${course.Add}")
    String AddCourse;

    @Value("${course.Delete}")
    String DeleteCourse;

    @Value("${course.Update}")
    String UpdateCourse;

    public  List<Course> getCourses() {
        return jdbcTemplate.query(
                findCourses,
            (rs, rowNum) ->
                    new Course(
                            rs.getLong("course_id"),
                            rs.getString("course_name"),
                            rs.getString("content")
                    )
    );
    }

    public int count() {
        return jdbcTemplate.queryForObject( CountCourses, Integer.class);
    }


    public int save(Course course) {
        return jdbcTemplate.update(
                AddCourse, course.getCourse_name(), course.getContent());
    }

    public int deleteById(Long course_id) {
        return jdbcTemplate.update(
                DeleteCourse, course_id);
    }

    public int update(Course course) {
        return jdbcTemplate.update(
               UpdateCourse ,
                course.getContent(), course.getCourse_id());
    }

}