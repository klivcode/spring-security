package com.springsecurity.securitydemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping
public class ApiController {


    @GetMapping(path="/hello")
    public String hello() {
        return "Hello World";
    }
    @PreAuthorize("hasRole('ADMIN')") // used to check the authorization
    @GetMapping(path = "/admin")
    public String admin() {
        return "Admin Dashboard";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "/user")
    public String user() {
        return "User Dashboard";
    }
}
