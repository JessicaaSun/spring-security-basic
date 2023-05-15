package com.example.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/homepage")
    public String userHomepage(){
        return "This is the user homepage";
    }

    @GetMapping("/feed")
    public String userFeed(){
        return "This is the user feed!!";
    }
}
