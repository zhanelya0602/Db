package com.company.kz.aitu.oop.practice.assignment4;

public class Employees {
    private int id;
    private String name;
    private int salary;
    private String specialty;
    private int projectsID;

    public Employees(int id, String name, int salary, String specialty) {

    }
    public Employees (int id,String name,int salary, String specialty, int projectsID){
        setId(id);
        setName(name);
        setSalary(salary);
        setSpecialty(specialty);
        setProjectsID(projectsID);
    }

    public Employees(String name, int salary, int projectsID) {
        setName(name);
        setSalary(salary);
        setProjectsID(projectsID);
    }

    private void setProjectsID(int projectsID) {
    }




    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getsalary(){
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getSpecialty(){
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", specialty=" + specialty +
                '}';
    }

    public int getSalary() {
        return salary;
    }
}
