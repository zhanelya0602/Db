package com.company.kz.aitu.oop.practice.assignment4.repositories;

import com.company.kz.aitu.oop.practice.assignment4.Projects;
import com.company.kz.aitu.oop.practice.assignment4.data1.interfaces.IDB1;
import com.company.kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectsRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectsRepository implements IProjectsRepository {



        private final IDB1 db;

        public ProjectsRepository(IDB1 db) {
            this.db = db;
        }

        @Override
        public  boolean createProjects(Projects projects) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "INSERT INTO users(name,surname,gender) VALUES (?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);

                  st.setString(1, projects.getName());


                boolean executed = st.execute();
                return executed;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return false;
        }

        @Override
        public Projects getProjectsById(int id) {
            return null;
        }



        public Projects getProjects(int id) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "SELECT id,name FROM projects WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setInt(1, id);

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    Projects projects = new Projects(rs.getInt("id"),
                            rs.getString("name"));


                    return projects;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return null;
        }

        @Override
        public List<Projects> getAllProjects() {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "SELECT id,name FROM projects";
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);
                List<Projects> projects1 = new ArrayList<>();
                while (rs.next()) {
                    Projects projects = new Projects(rs.getInt("id"),
                            rs.getString("name"));


                    projects1.add(projects);
                }

                return projects1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return null;
        }


    }

