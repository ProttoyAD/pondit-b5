package com.pondit.services;

import com.pondit.model.entities.User;
import com.pondit.model.enums.UserRole;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;
import java.util.Optional;

@ApplicationScoped
public class UserService extends BaseService<User> {

    @Override
    public Serializable save(User user) {
        return super.save(user);
    }

    public Optional<User> findByEmailAndRole(String email, String role) {
        var cb = getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query
                .where(
                        cb.equal(from.get("email"), email),
                        cb.equal(from.get("role"), UserRole.valueOf(role))
                );
        return super.query(query).getResultStream().findFirst();

    }
}
