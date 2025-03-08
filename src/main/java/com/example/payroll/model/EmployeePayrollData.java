package com.example.payroll.model;

import com.example.payroll.dto.EmployeePayrollDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private String department;
    private long salary;

    // Constructor to initialize fields from EmployeePayrollDTO
    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.getName();
        this.gender = employeePayrollDTO.getGender();
        this.department = employeePayrollDTO.getDepartment();
        this.salary = employeePayrollDTO.getSalary();
    }
}