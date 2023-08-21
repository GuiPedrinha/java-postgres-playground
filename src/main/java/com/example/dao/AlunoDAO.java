package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Aluno;

public class AlunoDAO {
    //atributos;
    private Connection conn;

    //construtor;
    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    //metodos;
    
    public void inserir(Connection conn, Aluno aluno) {
        //sql
        String sql = "INSERT INTO aluno (nome) VALUES (?)";

        try {
            //preparando statement;
            var statement = conn.prepareStatement(sql);

            //setando valores dos parametros;
            statement.setString(1, aluno.getNome());

            //executando DML insert;
            statement.executeUpdate();


            System.out.println("\n Aluno inserido com sucesso. \n");


        } catch (SQLException e) {
            System.err.println("Erro de SQL (inserir aluno)");
        }

        
    }

    public void inserirNota(Connection conn, int idDisciplina, int nota, Long matricula) {
        // sql
        String sql = "UPDATE aluno SET nota" + idDisciplina + " = ? WHERE matricula = ?";
    
        try {
            //preparando statement;
            var statement = conn.prepareStatement(sql);
            //setando parametros;
            statement.setInt(1, nota);
            statement.setLong(2, matricula);
            //executando DML update;
            statement.executeUpdate();
            System.out.println("\n Nota atualizada com sucesso. \n");

        } catch (SQLException e) {
            System.out.println("\n Nao foi possivel inserir a nota do aluno. \n");
        }

    }

    
}
