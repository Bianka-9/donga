package com.example.controllers;

import java.util.List;

import com.example.models.Employee;
import com.example.repositories.EmployeeRepository;
import com.example.views.EmployeeConsoleView;

public class EmployeeController {
    
    EmployeeRepository employeeRepository;
    EmployeeConsoleView employeeConsoleView;

    public EmployeeController(
        EmployeeRepository employeeRepository, 
        EmployeeConsoleView employeeConsoleView){
        this.employeeRepository = employeeRepository;
        this.employeeConsoleView = employeeConsoleView;
    };
    
    public void list(){
        List<Employee> empList = employeeRepository.findAll();
        employeeConsoleView.showEmployees(empList);
    }

    public void create(){
        Employee emp = new Employee(
            "Tar Ferenc",
            "Pécs",
            392,
            1);

            Employee createdEmp = employeeRepository.save(emp);
            System.out.println(createdEmp);
    }

    public void update(){
        Employee emp = new Employee(
            7,
            "Tarka Elemér",
            "Hatvan",
            393,
            2);
            Employee updatedEmp = employeeRepository.update(emp);
            System.out.println(updatedEmp);
    }

    public void delete(){
        int num = employeeRepository.delete(0);
        System.out.println("Érintett sorok: " + num);
    }
}
