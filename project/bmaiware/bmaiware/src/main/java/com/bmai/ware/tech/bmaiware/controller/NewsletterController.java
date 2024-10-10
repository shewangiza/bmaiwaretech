package com.bmai.ware.tech.bmaiware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsletterController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/subscribe")
    public ModelAndView subscribe(@RequestParam("email") String email) {
        // Save email to a database or process as needed
        // Send welcome email
        sendWelcomeEmail(email);

        // Return a view or redirect to a thank-you page
        return new ModelAndView("redirect:/thank-you");
    }

    private void sendWelcomeEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to BM AIwareTech Solutions Newsletter");
        message.setText("Thank you for subscribing to our newsletter! Stay tuned for the latest updates and news.");
        mailSender.send(message);
    }
}

