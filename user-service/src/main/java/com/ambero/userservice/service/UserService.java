package com.ambero.userservice.service;

import com.ambero.userservice.entity.User;
import com.ambero.userservice.model.Sector;
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

    Iterable<Sector> getAllSector();

}
