package com.ambero.sectorservice.controller;

import com.ambero.sectorservice.entity.Sector;
import com.ambero.sectorservice.exception.RequestException;
import com.ambero.sectorservice.service.SectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Sector sector) {
        if (sectorService.findByEmail(sector.getName()).isPresent())
            throw new RequestException(HttpStatus.NOT_FOUND, "Información ya se encuentra registrada");
        return ResponseEntity.status(HttpStatus.CREATED).body(sectorService.save(sector));
    }

    @GetMapping
    public ResponseEntity<List<Sector>> readAll() {
        List<Sector> sectores = (List<Sector>) sectorService.findAll();
        if(sectores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(sectores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable("id") UUID id) {
        log.info(String.valueOf(id));
        Optional<Sector> oSectores = sectorService.findById(id);
        if(oSectores.isEmpty())
            throw new RequestException(HttpStatus.NOT_FOUND, "Identificador de registro no encontrado");
        return ResponseEntity.ok(oSectores);
    }

}
