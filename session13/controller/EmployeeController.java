
package com.example.session13.controller;

import com.example.session13.entity.Employee;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Employee> getAllEmployees() {
        return Arrays.asList(
                new Employee(1, "Nguyen Van A", 15000000),
                new Employee(2, "Tran Thi B", 18000000),
                new Employee(3, "Le Van C", 20000000)
        );
    }
}
