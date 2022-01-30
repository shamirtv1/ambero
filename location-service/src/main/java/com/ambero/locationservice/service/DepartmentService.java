package com.ambero.locationservice.service;

import com.ambero.locationservice.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface DepartmentService {

    Iterable<Department> findAll();

    Page<Department> findAll(Pageable pageable);

    Optional<Department> findById(UUID id);

    Optional<Department> findByName(String name);

    Department save(Department user);

    void deleteById(UUID id);

}
