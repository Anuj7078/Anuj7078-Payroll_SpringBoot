package com.example.payroll.service;

import com.example.payroll.dto.EmployeePayrollDTO;
import com.example.payroll.model.EmployeePayrollData;
import com.example.payroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO) {
        log.info("Adding employee to the database: {}", employeePayrollDTO);
        EmployeePayrollData employeeData = new EmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeeData);
    }

    @Override
    public EmployeePayrollData getEmployeeById(int id) {
        log.info("Fetching employee by ID: {}", id);
        return employeePayrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        log.info("Fetching all employees from the database");
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO employeePayrollDTO) {
        log.info("Updating employee with ID: {}", id);
        EmployeePayrollData employeeData = getEmployeeById(id);
        employeeData.setName(employeePayrollDTO.getName());
        employeeData.setGender(employeePayrollDTO.getGender());
        employeeData.setDepartment(employeePayrollDTO.getDepartment());
        employeeData.setSalary(employeePayrollDTO.getSalary());
        return employeePayrollRepository.save(employeeData);
    }

    @Override
    public void deleteEmployee(int id) {
        log.info("Deleting employee with ID: {}", id);
        EmployeePayrollData employeeData = getEmployeeById(id);
        employeePayrollRepository.delete(employeeData);
    }
}