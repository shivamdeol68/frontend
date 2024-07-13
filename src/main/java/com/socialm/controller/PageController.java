package com.socialm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login"; // This will render login.html
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // This will render home.html
    }
}
