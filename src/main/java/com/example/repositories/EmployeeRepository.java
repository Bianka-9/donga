package com.example.repositories;

import java.util.List;

import com.example.dtos.DeleteResponse;
import com.example.dtos.EmployeeListResponse;
import com.example.dtos.EmployeeResponse;
import com.example.models.Employee;
import com.example.models.SimpleEmployee;

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
        SimpleEmployee simpleEmp = new SimpleEmployee(
            emp.getName(),
            emp.getCity(),
            emp.getSalary(),
            emp.getPositionId()
        );
        String json = ResConvert.toJson(simpleEmp);
        //System.out.println("JSON: " + json); - teszteléshez
        String response = client.post(url, json);
        EmployeeResponse res = ResConvert.toObject(response, EmployeeResponse.class);
        return res.data; 
        
    }

    @Override
    public Employee update(Employee emp) {
        String updateUrl = url + "/" + emp.getId();
        String json = ResConvert.toJson(emp);
        String response = client.put(updateUrl, json);
        EmployeeResponse res = ResConvert.toObject(response, EmployeeResponse.class);
        return res.data;
      
    }

    @Override
    public int delete(Integer id) {
        String deleterUrl = url + "/" + id;
        String json = client.delete(deleterUrl);
        DeleteResponse res = ResConvert.toObject(json, DeleteResponse.class);
        return res.data;
        
    }
    
}
