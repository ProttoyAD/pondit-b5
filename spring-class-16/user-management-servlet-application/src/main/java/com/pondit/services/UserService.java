package com.pondit.services;

import com.pondit.model.entities.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;

@ApplicationScoped
public class UserService extends BaseService<User> {

    @Override
    public Serializable save(User user) {
        return super.save(user);
    }
}
