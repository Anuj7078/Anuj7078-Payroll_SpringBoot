package com.example.payroll.service;

import com.example.payroll.dto.EmployeePayrollDTO;
import com.example.payroll.model.EmployeePayrollData;
import com.example.payroll.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeeData = new EmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeeData);
    }

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollRepository.findAll();
    }
}