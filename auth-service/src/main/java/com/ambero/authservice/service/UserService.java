package com.ambero.authservice.service;

import com.ambero.authservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Iterable<User> findAll();

    Page<User> findAll(Pageable pageable);

    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    User save(User user);

    void deleteById(UUID id);

}
