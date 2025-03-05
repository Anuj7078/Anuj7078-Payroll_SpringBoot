package com.example.payroll.service;

import com.example.payroll.dto.EmployeePayrollDTO;
import com.example.payroll.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO);
    List<EmployeePayrollData> getAllEmployees();
}