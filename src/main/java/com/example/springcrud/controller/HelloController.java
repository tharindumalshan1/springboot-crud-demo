package com.example.springcrud.controller;

public class HelloController {

    public String hello(String name){
        return String.format("Hello %s",name);
    }
}
