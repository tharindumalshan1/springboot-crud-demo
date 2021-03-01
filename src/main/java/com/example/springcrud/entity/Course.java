package com.example.springcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_id")
    private Long course_id;
    @Column(name = "course_name")
    private String course_name;
    @Column(name = "content")
    private String content;

    public Course(){
    }

    public Course(Long course_id, String course_name, String content) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
