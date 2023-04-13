package com.pondit;

import com.pondit.model.entities.User;
import com.pondit.model.enums.UserRole;
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

        var email = req.getParameter("email");
        if (email != null) {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            var query = em.createQuery("select u from User u where u.email = :email and u.role = :role ");
            query.setParameter("email", email);
            query.setParameter("role", UserRole.ADMIN);
            var resultList = query.getResultList();

            if (resultList.size() > 0) {
                em.close();
                req.setAttribute("user", resultList.get(0));
                req.getRequestDispatcher("hello.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Unable to save: User already exists in DB");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("hello.jsp").forward(req, resp);
        }
    }
}
