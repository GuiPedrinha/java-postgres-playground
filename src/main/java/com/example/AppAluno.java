package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.dao.AlunoDAO;
import com.example.dao.ConnectionManagerAluno;
import com.example.model.Aluno;

public class AppAluno {
    public static void main(String[] args) {
       new AppAluno();
        
    }

    
    AppAluno(){
        //carregagar biblioteca;
        carregarDriver();
        //criar conexao auto closable;
        try(var conn = ConnectionManagerAluno.getConnection()) {
            System.out.println("\n Conexao com o banco de dados realizada com sucesso. \n");

            var aluno = new Aluno();
            var alunoDAO = new AlunoDAO(conn);
            //matricual auto incremental e pkey

            //criando obj aluno;
            aluno.setNome("Isabela Pedrinha");

            //CRUD obj aluno na tabela;
            //alunoDAO.inserir(conn, aluno);
            alunoDAO.inserirNota(conn, 3, 9, 1L);

        } catch (SQLException e) {
            System.err.println("\n Nao foi possivel se conecatar ao banco de dados: " + e +"\n");
        }

    }

    private void carregarDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("\n Driver carregado com sucesso. \n");
        } catch (Exception e) {
            System.err.println("\n Nao foi possivel carregar o driver JDBC: " + e + "\n");
        }
    }



}
