package com.company.kz.aitu.oop.practice.assignment4.repositories.interfaces;

import com.company.kz.aitu.oop.practice.assignment4.Projects;

import java.util.List;

public interface IProjectsRepository {
    boolean createProjects(Projects projects);
    Projects getProjectsById(int id);
    List<Projects> getAllProjects();

}
