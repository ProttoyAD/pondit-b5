package com.rakib.controllers;
import jakarta.validation.Valid;
import com.rakib.dto.UserDto;
import com.rakib.entity.User;
import com.rakib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Validated
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(Model model, @Valid @ModelAttribute(name = "user") UserDto user, BindingResult theBindingResult){
        if (theBindingResult.hasErrors()) {
            String errorMessage = "Form submission failed due to following validation errors.<br><ul>";
            for (ObjectError error : theBindingResult.getAllErrors()) {
                errorMessage += "<li><h6>" + error.getDefaultMessage() + "</h6></li>";
            }
            errorMessage += "</ul>";
            model.addAttribute("template", "postEditor");
            model.addAttribute("user", user);
            model.addAttribute("errorMessage", errorMessage);
            return "register";
        }
        System.out.println(user);
        return "redirect:/user/all";
    }

    @GetMapping("/all")
    public String getAllUser(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "users";
    }

}
