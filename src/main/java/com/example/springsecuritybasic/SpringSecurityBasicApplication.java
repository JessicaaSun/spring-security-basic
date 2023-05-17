package com.example.springsecuritybasic;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityBasicApplication {

    public static void main(String[] args) {
        // create dotenv object
        Dotenv dotenv = Dotenv.configure().load();
        System.setProperty("MAIL_SERVER", dotenv.get("MAIL_SERVER"));
        System.setProperty("APP_PASSWORD", dotenv.get("APP_PASSWORD"));
        SpringApplication.run(SpringSecurityBasicApplication.class, args);
    }

}
