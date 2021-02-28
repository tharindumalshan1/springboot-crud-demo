package com.example.springcrud.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "user")
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
}
