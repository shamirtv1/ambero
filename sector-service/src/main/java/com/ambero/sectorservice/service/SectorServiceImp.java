package com.ambero.sectorservice.service;

import com.ambero.sectorservice.entity.Sector;
import com.ambero.sectorservice.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class SectorServiceImp implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Sector> findAll() {
        return sectorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Sector> findAll(Pageable pageable) {
        return sectorRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sector> findById(UUID id) {
        return sectorRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sector> findByEmail(String name) {
        return sectorRepository.findByName(name);
    }

    @Override
    @Transactional
    public Sector save(Sector sector) {
        return sectorRepository.save(sector);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        sectorRepository.deleteById(id);
    }
}
