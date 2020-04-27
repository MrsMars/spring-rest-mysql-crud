package com.aoher.service.impl;

import com.aoher.exception.ResourceNotFoundException;
import com.aoher.model.User;
import com.aoher.repository.UserRepository;
import com.aoher.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User service with crud operations
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        log.debug("Find user by id = {}", id);
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        log.debug("Founded user = {}", user);
        return user;
    }

    @Override
    public List<User> findAll() {
        log.debug("Find all users");
        List<User> users = userRepository.findAll();
        log.debug("Founded users = {}", users);
        return users;
    }

    @Override
    public User create(User user) {
        log.debug("Create user {}", user);
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        log.debug("Update user");
        User userToUpdate = findById(id);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAge(user.getAge());

        User updatedUser = create(user);
        log.debug("Old user = {}, new user = {}", userToUpdate, updatedUser);
        return updatedUser;
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete user by id = {}", id);
        User userToDelete = findById(id);
        log.debug("User to delete = {}", userToDelete);
        userRepository.delete(userToDelete);
    }
}
