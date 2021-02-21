package com.company.kz.aitu.oop.practice.assignment4.repositories.interfaces;

import com.company.kz.aitu.oop.practice.assignment4.Employees;

import java.util.List;

public interface IEmployeesRepository {
    boolean createEmployees(Employees employees);
    Employees getEmployeesById(int id);
    List<Employees> getAllEmployees();

}
