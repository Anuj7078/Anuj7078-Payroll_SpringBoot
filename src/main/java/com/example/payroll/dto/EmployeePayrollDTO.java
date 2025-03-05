package com.example.payroll.dto;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
    private String name;
    private String gender;
    private String department;
    private long salary;
}