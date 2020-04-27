package com.aoher.service;

import com.aoher.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User create(User user);

    User update(Long id, User user);

    void delete(Long id);
}
