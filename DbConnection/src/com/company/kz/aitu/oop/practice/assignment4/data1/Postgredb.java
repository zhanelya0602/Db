package com.company.kz.aitu.oop.practice.assignment4.data1;

import com.company.kz.aitu.oop.practice.assignment4.data1.interfaces.IDB1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgredb implements IDB1 {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/SimpleDb";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "bakibayeva0602");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
