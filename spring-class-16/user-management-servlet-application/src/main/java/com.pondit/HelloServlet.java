package com.pondit;

import com.pondit.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User user = User.builder()
                .name("Syed Hasan")
                .email("mainuls18@gmail.com")
                .password("secret")
                .build();

        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        req.setAttribute("user", user);
        req.getRequestDispatcher("hello.jsp").forward(req, resp);
    }
}
