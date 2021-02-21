package com.company.kz.aitu.oop.practice.assignment4.repositories;

import com.company.kz.aitu.oop.practice.assignment4.Employees;
import com.company.kz.aitu.oop.practice.assignment4.data1.interfaces.IDB1;
import com.company.kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeesRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesRepository implements IEmployeesRepository {
        private final IDB1 db;

        public EmployeesRepository(IDB1 db) {
            this.db = db;
        }

        @Override
        public boolean createEmployees(Employees employees) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "INSERT INTO employees(name,surname,specialty) VALUES (?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);

                st.setString(1, employees.getName());
                st.setInt(2, employees.getSalary());
                st.setString(3, employees.getSpecialty());

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
    public Employees getEmployeesById(int id) {
        return null;
    }



        @Override
        public List<Employees> getAllEmployees() {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "SELECT id,name,salary,specialty FROM employees";
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);
                List<Employees> users = new ArrayList<>();
                while (rs.next()) {
                    Employees employees = new Employees(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("salary"),
                            rs.getString("specialty"));

                    users.add(employees);
                }

                return users;
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


