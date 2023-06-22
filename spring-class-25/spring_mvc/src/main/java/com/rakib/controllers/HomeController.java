package com.rakib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping({"/", "/home"})
    public String showHome(Model model){
        model.addAttribute("msg", "welcome to home");
        return  "home";
    }
}
