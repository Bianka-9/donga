package com.example.views;

import java.util.List;

import com.example.models.Employee;

public class EmployeeConsoleView {
    public void showEmployees(List<Employee> empList){
        empList.forEach(emp -> {
            System.out.println(emp);
        });
    }
    public void createEmployee(){}    
}
