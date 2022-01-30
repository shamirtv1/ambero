package com.ambero.userservice.service;

import com.ambero.userservice.entity.User;
import com.ambero.userservice.feignclients.SectorFeignClient;
import com.ambero.userservice.model.Sector;
import com.ambero.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectorFeignClient sectorFeignClient;

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Sector> getAllSector(){
        return sectorFeignClient.readAll();
    }
}
