package com.example.springsecuritybasic.controller;

import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    // controller works with view engine

    @GetMapping("/homepage")
    @ResponseBody
    public String adminHomePage(){
        return "This is the admin homepage.";
    }

    @GetMapping("/feed")
    @ResponseBody
    public String adminFeed(){
        return "This is admin feed page";
    }
}
