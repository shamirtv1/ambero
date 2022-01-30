package com.ambero.sectorservice.service;

import com.ambero.sectorservice.entity.Sector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface SectorService {

    Iterable<Sector> findAll();

    Page<Sector> findAll(Pageable pageable);

    Optional<Sector> findById(UUID id);

    Optional<Sector> findByEmail(String email);

    Sector save(Sector user);

    void deleteById(UUID id);

}
