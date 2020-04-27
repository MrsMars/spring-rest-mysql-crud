package com.aoher.repository;

import com.aoher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
