package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerFinanceiro {
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDCB_URL = "jdbc:postgresql://localhost/postgres";
    

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDCB_URL, USERNAME, PASSWORD); 
    }
}
