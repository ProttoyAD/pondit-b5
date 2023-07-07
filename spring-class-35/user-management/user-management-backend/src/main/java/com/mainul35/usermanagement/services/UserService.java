package com.mainul35.usermanagement.services;

import com.mainul35.usermanagement.entities.User;
import com.mainul35.usermanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    public User findUser(long id) {
        return (userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found")));
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

}
