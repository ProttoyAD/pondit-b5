package com.pondit.servlets;

import com.pondit.model.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userProfileServlet", value = "/user/profile")
public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var user = (User) session.getAttribute("loggedInUser");
        req.setAttribute("user", user);
        req.getRequestDispatcher(req.getContextPath() + "/pages/profile/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
