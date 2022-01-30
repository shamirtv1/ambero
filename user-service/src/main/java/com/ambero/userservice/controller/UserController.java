package com.ambero.userservice.controller;

import com.ambero.userservice.entity.User;
import com.ambero.userservice.exception.RequestException;
import com.ambero.userservice.model.Sector;
import com.ambero.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User usuario) {

        if (userService.findByEmail(usuario.getEmail()).isPresent())
            throw new RequestException(HttpStatus.NOT_FOUND, "Información ya se encuentra registrada");
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usuario));
    }

    @GetMapping
    public ResponseEntity<List<User>> readAll() {
        List<User> users = (List<User>) userService.findAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable("id") UUID id) {
        log.info(String.valueOf(id));
        Optional<User> oUsuario = userService.findById(id);
        if(oUsuario.isEmpty())
            throw new RequestException(HttpStatus.NOT_FOUND, "Identificador de registro no encontrado");
        return ResponseEntity.ok(oUsuario);
    }

    @CircuitBreaker(name = "sectorCB", fallbackMethod = "fallbackGetSector")
    @GetMapping("/sector")
    public ResponseEntity<?> getSector() {
        List<Sector> sectores = (List<Sector>) userService.getAllSector();
        if(sectores.isEmpty())
            throw new RequestException(HttpStatus.NOT_FOUND, "Sectores no registrados");
        return ResponseEntity.ok(sectores);
    }

    private ResponseEntity<?> fallbackGetSector(RuntimeException e) {
        return new ResponseEntity("El usurio no tiene sectores asociados", HttpStatus.OK);
    }

}
