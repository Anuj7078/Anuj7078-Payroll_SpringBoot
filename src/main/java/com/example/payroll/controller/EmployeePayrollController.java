package com.example.payroll.controller;

import com.example.payroll.dto.EmployeePayrollDTO;
import com.example.payroll.model.EmployeePayrollData;
import com.example.payroll.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @PostMapping("/add")
    public ResponseEntity<EmployeePayrollData> addEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeeData = employeePayrollService.addEmployee(employeePayrollDTO);
        return new ResponseEntity<>(employeeData, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployees() {
        List<EmployeePayrollData> employeeDataList = employeePayrollService.getAllEmployees();
        return new ResponseEntity<>(employeeDataList, HttpStatus.OK);
    }
}