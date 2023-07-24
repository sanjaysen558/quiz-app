package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("hello")
    public String greet(){
        return "<h1>Hello Sanjay, Welcome to the 'Spring-boot Application'.</h1>";
    }
}
