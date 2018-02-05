package com.sfl.service;

import com.sfl.entity.Role;
import com.sfl.entity.User;
import com.sfl.repsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Karlen on 05.02.2018.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUserByUsername(final String username) {
        Assert.notNull(username, "Username should not be empty");
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void addUser(final User user) {
        Assert.notNull(user, "User should not be null");
        Assert.hasText(user.getPassword(), "User should not be null");

        final User one = userRepository.findByUsername(user.getUsername());

        if (one != null) {
            throw new RuntimeException("User with given username exist. Cant create new one.");
        }

        final String password = user.getPassword();

        final String encodePassword = new BCryptPasswordEncoder().encode(password);

        user.setPassword(encodePassword);

        userRepository.save(user);
    }

    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    public List<User> getUsersListWereRoleIsWAITER() {
        return userRepository.findByRole(Role.WAITER);
    }

    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

}
