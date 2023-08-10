package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.Driver;

public class AppBdclean {
    //refatorado extract to constraint; o "final" quer dizer isso;
    //constantes sao sempre UPPERCASE;
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";


    public static void main(String[] args) {
        //chamando apenas o construtor;
        new AppBdclean();
    }

    // tirar os statics, passar tudo pra uns constrututor pra fazer só 1 vez;
    // passando o tratamento da conexao tbm pra dentro do construtor;
    public AppBdclean(){
        try (var conn =  getConnection()){
            carregarDriverJDBC(conn);
            listaEstados(conn);
            localizarEstado("TO");
        } catch (SQLException e) {
            //unico erro que o construc vai ter ciencia é o de conexao;
            // os outros ainda sao tratados em quem chamar o listarEstados;
                System.err.println(" Nao foi possivel conectar ao banco de dados " + e.getMessage());
        }
    }

  private void localizarEstado(String uf) {
    }

  private void listaEstados(Connection conn) {

        // agora sao trys independentes; refatorar em metodos separados;
        //p/ saber se erro foi na conexao ou no comando sql declarar variavel statment fora do bloco;
        // cuidado com imports. é statement sql nao beans;
        //inicializando statement. sem var agora pq var so intra bloco funciona;
        //REFATORADO - apos pronto refactor -> extract to method;

        try {
            System.out.println("Conexao com o banco de dados realizada com sucesso!");
            
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while (result.next()) {
            System.out.printf("Id: %d Nome: %s UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
        //tratamento diferenciando erro de conexao com erro de sintaxe da consulta sql;    
        } catch (SQLException e) {
             System.err.println(" Erro ao realizar o comando query sql ");
            //pode usar System.err.println pra mostrar a msg em vermelho de erro;
        }
    }

    // foi refatorado pq sempre vai ser chamado isso pra criar uma conexao;
    // usou throws para delegar o tratamento dessa conexao ao metodo que chamar este;
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void carregarDriverJDBC(Connection conn) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel carregar o banco de dados" + e.getMessage());
        }
    }
}
