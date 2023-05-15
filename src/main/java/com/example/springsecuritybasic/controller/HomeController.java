package com.example.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/homepage")
    public String homepage(){
        return "This is the public homepage";
    }

    @GetMapping("/feed")
    public String feed(){
        return "This is the public feed";
    }
}
