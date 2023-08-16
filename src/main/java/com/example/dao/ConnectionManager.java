package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    //refatorado extract to constraint; o "final" quer dizer isso;
    //constantes sao sempre UPPERCASE;
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";

    //como a classe nao tem atributos e nao armazena objetos...;
    // usar static pra nao precisa instaciar a classe pra usar getconecction;
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
    
}
