package com.pondit.servlets;

import com.pondit.model.entities.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("user", resultList.get(0));
        request.getRequestDispatcher("pages/registration/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var user = new User();
        var userStr = request.getParameterMap();
        request.getRequestDispatcher("pages/registration/registration-success.jsp").forward(request, response);
    }
}
