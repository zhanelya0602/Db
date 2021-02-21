package com.company.kz.aitu.oop.practice.assignment4.data1.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB1 {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
