package com.mainul35.socialloginclient.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String login (Model model, @RequestParam(value = "action", required = false) String action) {
        if (action != null) {
            model.addAttribute("actionMessage", "You have been logged out!");
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout (Model model) {
        SecurityContextHolder.clearContext();
        return "redirect:/auth/login?action=logout";
    }


}
