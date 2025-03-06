package com.example.payroll.service;

import com.example.payroll.dto.EmployeePayrollDTO;
import com.example.payroll.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO);
    EmployeePayrollData getEmployeeById(int id);
    List<EmployeePayrollData> getAllEmployees();
    EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO employeePayrollDTO);
    void deleteEmployee(int id);
}