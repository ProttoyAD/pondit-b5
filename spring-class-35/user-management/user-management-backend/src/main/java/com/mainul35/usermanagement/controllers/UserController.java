package com.mainul35.usermanagement.controllers;

import com.mainul35.usermanagement.dto.UserRequest;
import com.mainul35.usermanagement.dto.UserResponse;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    private List<UserResponse> users = new ArrayList<>();

    public UserController() {
    }

    @GetMapping("/all")
    public List<UserResponse> getUsers() {
        return users;
    }

    @PostMapping("/add")
    public List<UserResponse> addUser(@RequestBody UserRequest user) {
        var found = users.stream().anyMatch(u -> u.name().equals(user.name()));
        if (found) {
            throw new RuntimeException("User already added");
        }
        this.users.add(new UserResponse(user.name()));
        return this.users;
    }
}
