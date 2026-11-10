package com.example.session13.entity;

public class Employee {
    private int id;
    private String fullName;
    private double salary;

    public Employee(int id, String fullName, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }
}
