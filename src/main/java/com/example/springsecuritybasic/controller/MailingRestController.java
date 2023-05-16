package com.example.springsecuritybasic.controller;

import com.example.springsecuritybasic.service.MailingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class MailingRestController {
    private final MailingService mailingService;
    MailingRestController(MailingService mailingService){
        this.mailingService = mailingService;
    }

    @PostMapping("/sendingmail")
    public String sendMail(){
        try{
            mailingService.sendingEmail("sunjessica05@gmail.com", "Here is the email", "sending email from application");
            return "Successfully sent email";
        } catch (Exception ex){
           ex.printStackTrace();
            return "Fail to send mail";
        }
    }

}
