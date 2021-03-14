package com.example.springcrud.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "user")
//@SecondaryTable(name = "course", pkJoinColumns = @PrimaryKeyJoinColumn(name = "course_id"))
@Getter
@Setter
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

    public User( String name, String email) {
      this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
    }
}
