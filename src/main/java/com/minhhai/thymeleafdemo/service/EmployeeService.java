package com.minhhai.thymeleafdemo.service;

import com.minhhai.thymeleafdemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
