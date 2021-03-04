package com.example.springcrud.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void hello() {
        HelloController demo = new HelloController();
        String res = demo.hello("World");
        assertEquals("Hello World", res);
    }
}