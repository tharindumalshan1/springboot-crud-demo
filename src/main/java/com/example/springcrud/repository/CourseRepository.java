package com.example.springcrud.repository;

import com.example.springcrud.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Repository
@Primary
public class CourseRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private static final String SQL = "select * from course";
//
//    public List<Course> getCourses() {
//
//        List<Course> courses = new ArrayList<Course>();
//        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
//
//        for (Map<String, Object> row : rows)
//        {
//            Course course = new Course();
//            course.setCourse_id((Long)row.get("course_id"));
//            course.setCourse_name((String)row.get("course_name"));
//            course.setContent((String)row.get("content"));
//
//            courses.add(course);
//        }
//
//        return courses;
//    }
    public List<Course> getCourses() {
    return jdbcTemplate.query(
            "select * from course",
            (rs, rowNum) ->
                    new Course(
                            rs.getLong("course_id"),
                            rs.getString("course_name"),
                            rs.getString("content")
                    )
    );
}

    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from course", Integer.class);
    }

    public int save(Course course) {
        return jdbcTemplate.update(
                "insert into course (course_name, content) values(?,?)",
                course.getCourse_name(), course.getContent());
    }

    public int deleteById(Long course_id) {
        return jdbcTemplate.update(
                "delete from course where course_id = ?", course_id);
    }

    public int update(Course course) {
        return jdbcTemplate.update(
                "update course set content = ? where course_id = ?",
                course.getContent(), course.getCourse_id());
    }

}