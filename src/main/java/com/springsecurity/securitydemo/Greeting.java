package com.springsecurity.securitydemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping
public class Greeting {


    @GetMapping(path="/hello")

    public String hello() {
        return "Hello World";
    }
}
