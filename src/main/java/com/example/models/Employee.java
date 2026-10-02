package com.example.models;

public class Employee {
    int id;
    String name;
    String city;
    int salary;
    int positionId;
    
    public Employee() {
    }

    public Employee(String name, String city, int salary, int positionId) {
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.positionId = positionId;
    }

    public Employee(int id, String name, String city, int salary, int positionId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.positionId = positionId;
    }

    @Override 
    public String toString(){
        return id + " " + name + " " + city + " " + salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    
}
