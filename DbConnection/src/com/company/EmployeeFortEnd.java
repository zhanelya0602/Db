package com.company;


import com.company.kz.aitu.oop.practice.assignment4.controllers.EmployeeControllers;
import com.company.kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeesRepository;
import com.company.kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectsRepository;

import java.util.Scanner;

public class EmployeeFortEnd {

        private final EmployeeControllers controllers;
        private final Scanner scanner;

        public EmployeeFortEnd(IEmployeesRepository employeesRepository, IProjectsRepository projectsRepository) {
            controllers = new EmployeeControllers(employeesRepository,projectsRepository);
            scanner = new Scanner(System.in);
        }



    public void start() {
            while (true) {
                System.out.println();
                System.out.println("Welcome to My Application");
                System.out.println("Select option:");
                System.out.println("1. Get all employees");
                System.out.println("2. Get employees by id");
                System.out.println("3. Create employee");
                System.out.println("4. Create projects");
                System.out.println("5. Create all projects");
                System.out.println("6. Create projects by id");
                System.out.println("0. Exit");
                System.out.println();
                try {
                    System.out.print("Enter option (1-3): ");
                    int option = scanner.nextInt();
                    if (option == 1) {
                        getAllEmployeesMenu();
                    } else if (option == 2) {
                        getEmployeesByIdMenu();
                    } else if (option == 3) {
                        createEmployeesMenu();
                    } else if(option == 4){
                        createProjectsMenu();
                    } else if (option == 5){
                        getAllProjectsMenu();
                    } else if (option == 6){
                        getAllProjectsMenu();
                    } else{
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scanner.next(); // to ignore incorrect input
                }

                System.out.println("*************************");

            }
        }

        public void getAllEmployeesMenu() {
            String response = controllers.getAllEmployees();
            System.out.println(response);
        }

        public void getEmployeesByIdMenu() {
            System.out.println("Please enter id");

            int id = scanner.nextInt();
            int response = controllers.getEmployeesById(id);
            System.out.println(response);
        }

        public void createEmployeesMenu() {
            System.out.println("Please enter projects id:");
            int projectsId = scanner.nextInt();
            if (controllers.getProjectsById(projectsId)<1) {
                return;
            }
            System.out.println("Please enter name");
            String name = scanner.next();
            System.out.println("Please enter salary ");
            int salary = scanner.nextInt();
            System.out.println("Please enter specialty");
            String specialty = scanner.next();

            String response = controllers.createEmployees(name, salary, specialty);
            System.out.println(response);
        }

    public void createProjectsMenu() {
        System.out.println("Please enter name projects");
        String name = scanner.next();
        String response = controllers.createProjects(name);
        System.out.println(response);
    }
    public void getAllProjectsMenu(){
            String response = controllers.getAllProjects();
        System.out.println(response );
    }
}
