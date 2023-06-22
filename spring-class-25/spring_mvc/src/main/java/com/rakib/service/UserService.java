package com.rakib.service;

import com.rakib.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public  User getUserById(Long id);
    public  void saveUser(User user);
    public void deleteUser(User user);
}
