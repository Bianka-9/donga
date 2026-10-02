package com.example;

import com.example.controllers.EmployeeController;
import com.example.repositories.EmployeeRepository;
import com.example.views.EmployeeConsoleView;

public class Main {
    public static void main(String[] args) {
    

        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeConsoleView employeeConsoleView = new EmployeeConsoleView();
        EmployeeController employeeController= new EmployeeController(employeeRepository, employeeConsoleView);
        //employeeController.create();
       // employeeController.update();
        employeeController.delete();
        employeeController.list();
    }
}