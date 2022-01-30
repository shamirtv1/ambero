package com.ambero.sectorservice.repository;

import com.ambero.sectorservice.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SectorRepository extends JpaRepository<Sector, UUID> {
    Optional<Sector> findByName(String name);
}
