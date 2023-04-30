package com.pondit.servlets;

import com.pondit.configurations.PasswordHashGenerator;
import com.pondit.model.entities.User;
import com.pondit.model.enums.UserRole;
import com.pondit.services.UserService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@Named
@WebServlet(name = "RegistrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {

    @Inject
    private PasswordHashGenerator passwordHashGenerator;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/registration/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var user = new User();
        var userStr = request.getParameterMap();
        user.setName(userStr.get("name")[0]);
        user.setRole(UserRole.USER);
        user.setEmail(userStr.get("email")[0]);
        boolean matched = userStr.get("password")[0].equals(userStr.get("repassword")[0]);
        if (matched) {
            user.setPassword(passwordHashGenerator.generate(userStr.get("password")[0].toCharArray()));
        } else {
            throw new RuntimeException("Passwords did not match!");
        }

        var savedUserId = userService.save(user);

        System.out.println(savedUserId);

        request.getRequestDispatcher("pages/registration/registration-success.jsp").forward(request, response);
    }
}
