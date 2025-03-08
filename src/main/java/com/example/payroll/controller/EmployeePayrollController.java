package com.example.payroll.controller;

import com.example.payroll.dto.EmployeePayrollDTO;
import com.example.payroll.model.EmployeePayrollData;
import com.example.payroll.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @PostMapping
    public ResponseEntity<EmployeePayrollData> addEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        log.info("Adding a new employee: {}", employeePayrollDTO);
        EmployeePayrollData employeeData = employeePayrollService.addEmployee(employeePayrollDTO);
        return new ResponseEntity<>(employeeData, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployees() {
        log.info("Fetching all employees");
        List<EmployeePayrollData> employeeDataList = employeePayrollService.getAllEmployees();
        return new ResponseEntity<>(employeeDataList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable int id) {
        log.info("Fetching employee by ID: {}", id);
        EmployeePayrollData employeeData = employeePayrollService.getEmployeeById(id);
        return new ResponseEntity<>(employeeData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeePayrollData> updateEmployee(@PathVariable int id, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        log.info("Updating employee with ID: {}", id);
        EmployeePayrollData employeeData = employeePayrollService.updateEmployee(id, employeePayrollDTO);
        return new ResponseEntity<>(employeeData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        log.info("Deleting employee with ID: {}", id);
        employeePayrollService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}