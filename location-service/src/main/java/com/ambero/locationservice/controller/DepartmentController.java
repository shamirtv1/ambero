package com.ambero.locationservice.controller;

import com.ambero.locationservice.entity.Department;
import com.ambero.locationservice.exception.RequestException;
import com.ambero.locationservice.service.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Department department) {
        if (departmentService.findByName(department.getName()).isPresent())
            throw new RequestException(HttpStatus.NOT_FOUND, "Información ya se encuentra registrada");
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> readAll() {
        List<Department> departments = (List<Department>) departmentService.findAll();
        if(departments.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable("id") UUID id) {
        log.info(String.valueOf(id));
        Optional<Department> oDepartments = departmentService.findById(id);
        if(oDepartments.isEmpty())
            throw new RequestException(HttpStatus.NOT_FOUND, "Identificador de registro no encontrado");
        return ResponseEntity.ok(oDepartments);
    }

}
