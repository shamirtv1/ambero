package com.ambero.locationservice.service;

import com.ambero.locationservice.entity.Department;
import com.ambero.locationservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Department> findById(UUID id) {
        return departmentRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        departmentRepository.deleteById(id);
    }
}
