package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/")
    public String Message() {
        return "Success";
    }

    @RequestMapping("/hello")
    public String Hello() {
        return "Hello World";
    }
}
