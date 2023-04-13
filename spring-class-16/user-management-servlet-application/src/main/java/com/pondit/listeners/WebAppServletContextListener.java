package com.pondit.listeners;

import com.pondit.model.entities.User;
import com.pondit.model.enums.UserRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;

@WebListener
public class WebAppServletContextListener implements ServletContextListener {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(WebAppServletContextListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // stuff to do on context destroy
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // stuff todo at context startup
        log.info("Attempting DB initialization...");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        User user = User.builder()
                .name("Syed Hasan")
                .email("mainuls18@gmail.com")
                .password("secret")
                .role(UserRole.ADMIN)
                .build();

        var query = em.createQuery("select u from User u where u.email = :email ");
        query.setParameter("email", user.getEmail());
        var result = query.getFirstResult();

        if (query.getResultList().size() < 1) {
            em.persist(user);
            em.getTransaction().commit();
            em.close();
            log.info("Initialization complete");
        } else {
            log.info("User already exists in DB. Skipping initialization");
        }
    }
}