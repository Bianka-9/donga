package com.example.repositories;

import java.util.List;

import com.example.dtos.EmployeeListResponse;
import com.example.dtos.EmployeeResponse;
import com.example.models.Employee;

import hu.szit.resclient.ResClient;
import hu.szit.resclient.ResConvert;

public class EmployeeRepository implements Repository<Employee, Integer> {

    private final String url ="http://localhost:8000/api/employees";
    ResClient client = new ResClient();

    @Override
    public List<Employee> findAll() {
        String json = client.get(url);
        EmployeeListResponse res = ResConvert.toObject(json, EmployeeListResponse.class);
        List<Employee> empList = res.data;
        return empList;
    }

    @Override
    public Employee save(Employee emp) {
        String json = ResConvert.toJson(emp);
        String response = client.post(url, json);
        EmployeeResponse res = ResConvert.toObject(response, EmployeeResponse.class);
        return res.data; 
        
    }

    @Override
    public Employee update(Employee t) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
