package com.pondit.services;

import jakarta.persistence.Entity;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.Properties;


public abstract class BaseService<T> {

    private SessionFactory sessionFactory = null;

    private Session session;

    public Session getSession() {
        try (Session session = createAndGetLocalSessionFactoryBean().getCurrentSession()) {
            this.session = session != null
                    ? session
                    : sessionFactory.openSession();
            return session;
        } catch (HibernateException e) {
            this.session = session != null
                    ? session
                    : sessionFactory.openSession();
            return session;
        }
    }

    public SessionFactory createAndGetLocalSessionFactoryBean() {
        if (this.sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = getBuiltProperties("hibernate.properties");

                configuration.setProperties(settings);
                configuration.addPackage("com.pondit.model.entities");
                for (Class<?> clazz : (new Reflections("com.pondit.model.entities")).getTypesAnnotatedWith(Entity.class)) {
                    if (!Modifier.isAbstract(clazz.getModifiers())) {
                        configuration.addAnnotatedClass(clazz);
                    }
                }
                StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(settings);
                sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private Properties getBuiltProperties(String propertyFileName) {
        Properties properties = new Properties();
        InputStream input = BaseService.class
                .getClassLoader().getResourceAsStream(propertyFileName);
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    protected Serializable save(T object) {
        var session = getSession();
        var tx = session.getTransaction();
        if (!tx.isActive())
            tx = session.beginTransaction();
        var id = session.save(object);
        session.flush();
        tx.commit();
        return id;
    }

    protected void delete(T object) {
        var session = getSession();
        var tx = session.getTransaction();
        if (!tx.isActive())
            tx = session.beginTransaction();
        session.delete(object);
        session.flush();
        tx.commit();
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        Session session = getSession();
        var tx = session.getTransaction();
        if (!tx.isActive()) {
            tx = session.beginTransaction();
        }
        return session.getCriteriaBuilder();
    }

    protected <T> TypedQuery<T> query(CriteriaQuery<T> query) {
        return getSession().getEntityManagerFactory().createEntityManager().createQuery(query);
    }
}
