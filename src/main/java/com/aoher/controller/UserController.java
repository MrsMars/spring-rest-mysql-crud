package com.aoher.controller;

import com.aoher.exception.ResourceNotFoundException;
import com.aoher.model.User;
import com.aoher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * User controller
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Gets user by id
     *
     * @param id the user id
     * @return user by id
     * @throws ResourceNotFoundException if user is not found
     */
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    /**
     * Gets all users
     *
     * @return list of users
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    /**
     * Creates user
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    /**
     * Updates user
     *
     * @param id   the user id
     * @param user user to update
     * @return updated user
     * @throws ResourceNotFoundException if user is not found
     */
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        return userService.update(id, user);
    }

    /**
     * Deletes user by id
     *
     * @param id the user id
     * @return ResponseEntity
     * @throws ResourceNotFoundException if user is not found
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
