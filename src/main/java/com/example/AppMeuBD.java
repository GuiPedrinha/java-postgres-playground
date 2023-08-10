package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppMeuBD {
    //atributos;
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";

    //main;
    public static void main(String[] args) {
        new AppMeuBD();
    }

    //constructor;
    public AppMeuBD(){
        try(var conn = openConnection()) {
            loadBdDriver(conn);
            listarCidades(conn);
        } catch (SQLException e) {
            System.err.println("Conexao nao pode ser criada com o banco de dados");
        }
    }



    //metodos;
    private void listarCidades(Connection conn) {
        Statement statement = null;
        try{
            //criar statement java sql NAO JAVA BEANS!;
            statement = conn.createStatement();

            //usar statement para pegar resultSet;
            var result = statement.executeQuery("select * from cidade");

            //imprimir result com whilte e result.next;
            while(result.next()){
                //com printf;
                System.out.printf("Id: %d Nome: %s Capital: %s \n", result.getInt("id"), result.getString("nome"), result.getString("capital"));
            }

        } catch (SQLException e) {
            if(statement == null){
                System.err.println("nao foi possivel abrir conexao");
            }else
            System.err.println("Sintaxe sql errada.");
        }
    }





    private Connection openConnection() throws SQLException{
            System.out.println("Conexao efetuada com sucesso");
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }





    private void loadBdDriver(Connection conn) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("driver carregado com sucesso");
        } catch (ClassNotFoundException e) {
            System.out.println("Nao foi possivel carregar o Driver");
        }
    }
}
