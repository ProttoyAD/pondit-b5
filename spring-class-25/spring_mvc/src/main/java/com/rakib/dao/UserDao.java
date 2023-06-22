package com.rakib.dao;

import com.rakib.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(Long id);

    public void deleteUser(User user);
}
