package com.company.kz.aitu.oop.practice.assignment4.controllers;

import com.company.kz.aitu.oop.practice.assignment4.Employees;
import com.company.kz.aitu.oop.practice.assignment4.Projects;
import com.company.kz.aitu.oop.practice.assignment4.repositories.ProjectsRepository;
import com.company.kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeesRepository;
import com.company.kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectsRepository;

import java.util.List;

public class EmployeeControllers {
    private final IEmployeesRepository employeesRepository;
    private final IProjectsRepository projectsRepository;

    public EmployeeControllers(IEmployeesRepository employeesRepository, IProjectsRepository projectsRepository){
        this.employeesRepository=employeesRepository;
        this.projectsRepository=projectsRepository;
    }
    public String creteEmployees(String name,int salary,int projectsID){
        Employees employees=new Employees(name,salary,projectsID);
        boolean created = employeesRepository.createEmployees(employees);
        return (created ? "Employees was created": "Employees creation was failed!");
    }
    public String getAllEmployees(){
        List<Employees> employees=employeesRepository.getAllEmployees();
        return employees.toString();
    }
    public String createProjects (String name){
        Projects projects=new Projects(name);
        boolean created = projectsRepository.createProjects(projects);
        return (created ? "Projects was created":"Projects creation was failed!");
    }
    public int getProjectsById (int id){
        Projects projects = projectsRepository.getProjectsById(id);
        return getProjectsById(id);
    }
    public String getAllProjects(){
        List<Projects> projects = projectsRepository.getAllProjects();
        return projects.toString();
    }

    public int getEmployeesById(int id) {
        return id;
    }


    public String createEmployees(String name, int salary, String specialty){
        return name;

    };
}
