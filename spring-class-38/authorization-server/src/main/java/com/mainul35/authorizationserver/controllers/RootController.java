package com.mainul35.authorizationserver.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping("/login")
    public String login (Model model,
                         @RequestParam(value = "action", required = false) String action,
                         @RequestParam(value = "applicationCalling", required = false) String applicationCalling
    ) {
        if (action != null) {
            model.addAttribute("actionMessage", "You have been logged out!");
        }
        model.addAttribute("applicationCalling", "bloggingApp");
        return "login";
    }

    @GetMapping("/logout")
    public String logout (Model model) {
        SecurityContextHolder.clearContext();
        return "redirect:/login?action=logout";
    }
}
