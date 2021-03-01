package com.example.springcrud.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "user")
@SecondaryTable(name = "course", pkJoinColumns = @PrimaryKeyJoinColumn(name = "course_id"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

//    @Column(name ="course_id")
//    private String course_id


//    @Column(name = "course_id", table = "course")
//    long course_id;

    @Column(name = "course_name", table = "course")
    String course_name;

    @Column(name = "content", table = "course")
    String Content;

}
