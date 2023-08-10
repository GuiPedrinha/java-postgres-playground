package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppMeuBD {
    public static void main(String[] args) {
        
        //Carregando driver;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("driver carregado com sucesso");
        } catch (ClassNotFoundException e) {
            System.out.println("Nao foi possivel carregar o Driver");
        }

        //abrir conexao autoclosable com DriverManager;
        try(var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "")) {
            System.out.println("Conexao efetuada com sucesso");

            //criar statement java sql NAO JAVA BEANS!;
            Statement statement = conn.createStatement();

            //usar statement para pegar resultSet;
            var result = statement.executeQuery("select * from cidade");

            //imprimir result com whilte e result.next;
            while(result.next()){
                //com printf;
                System.out.printf("Id:");
            }

        } catch (SQLException e) {
            System.out.println("nao foi possivel abrir conexao");

        }


    }
}
