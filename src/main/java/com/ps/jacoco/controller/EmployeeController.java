package com.ps.jacoco.controller;

import com.ps.jacoco.exception.ResourceNotFoundException;
import com.ps.jacoco.model.Employee;
import com.ps.jacoco.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/test")
    public String test() {
           return "UP";
    }
    @GetMapping("/employees")
    public List<Employee> showEmployees()
    {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employeeById/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) throws ResourceNotFoundException {
         Employee employee=employeeService.findEmployeeById(id).orElseThrow(()->new ResourceNotFoundException("Employee not available for this employee id"));
         return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);
    }




}
