package com.example.payroll.service;

import com.example.payroll.dto.EmployeePayrollDTO;
import com.example.payroll.model.EmployeePayrollData;
import com.example.payroll.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public EmployeePayrollData getEmployeeById(int id) {
        return employeePayrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeeData = getEmployeeById(id);
        employeeData.setName(employeePayrollDTO.getName());
        employeeData.setGender(employeePayrollDTO.getGender());
        employeeData.setDepartment(employeePayrollDTO.getDepartment());
        employeeData.setSalary(employeePayrollDTO.getSalary());
        return employeePayrollRepository.save(employeeData);
    }

    @Override
    public void deleteEmployee(int id) {
        EmployeePayrollData employeeData = getEmployeeById(id);
        employeePayrollRepository.delete(employeeData);
    }
}