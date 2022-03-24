package com.minhhai.thymeleafdemo.dao;

import com.minhhai.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
