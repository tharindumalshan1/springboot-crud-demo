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

    /**
     * Returns the count of all available courses
     * This will return an number if no of courses are available
     * @return  no of courses
     */
    int count();

    /**
     * Creates a new course
     * @param course the new Course to be created
     * @return the created course
     */
    int save(Course course);

    /**
     * Deletes the course with the given course Id
     * @param course_id the Id of the course to delete
     * @return 1 if a was deleted successfully
     */
    int deleteById(Long course_id);

    /**
     * Modify the details of an existing courses
     * Method will always return the updated course after a successful operation
     * @param course the User being modified
     * @return  the course with updated details
     */
    int update(Course course);
}
