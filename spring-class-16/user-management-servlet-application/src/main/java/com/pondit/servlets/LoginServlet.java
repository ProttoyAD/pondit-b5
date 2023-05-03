package com.pondit.servlets;

import com.pondit.configurations.PasswordHashGenerator;
import com.pondit.model.entities.User;
import com.pondit.model.enums.UserRole;
import com.pondit.services.UserService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Named
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private PasswordHashGenerator passwordHashGenerator;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var user = new User();
        var userStr = request.getParameterMap();
        var email = userStr.get("email")[0];
        var userOptionalFromDb = userService.findByEmailAndRole(email, UserRole.USER.toString());
        if (userOptionalFromDb.isEmpty())
            throw new RuntimeException("No user found with this username");

        var userFromDb = userOptionalFromDb.get();
        var password = userStr.get("password")[0];
        var matched = passwordHashGenerator.verify(password.toCharArray(), userFromDb.getPassword());
        if (!matched)
            throw new RuntimeException("Invalid credentials");

        var session = request.getSession();

        session.setAttribute("loggedInUser", userFromDb);

        JsonObject json = Json.createObjectBuilder()
                        .add("message", "Logged in successfully")
                                .build();
        response.setContentType("application/json");
        var out = response.getWriter();
        out.print(json.toString());
    }
}
