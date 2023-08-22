package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.example.model.Aluno;

public class AlunoDAO {
    //atributos;
    private Connection conn;

    //construtor;
    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    //metodos;
    
    public void inserir(Aluno aluno) {
        //sql
        String sql = "INSERT INTO aluno (nome) VALUES (?)";

        try {
            //preparando statement;
            var statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //setando valores dos parametros;
            statement.setString(1, aluno.getNome());

            //executando DML insert;
            statement.executeUpdate();

            // retornando matricula criada pelo banco;
            var result = statement.getGeneratedKeys();

            if (result.next()) {
                aluno.setMatricula(result.getLong("matricula"));
                System.out.printf("\n Matricula inserida: %d \n", result.getLong("matricula"));
            }


            System.out.println("\n Aluno inserido com sucesso. \n");


        } catch (SQLException e) {
            System.err.println("Erro de SQL (inserir aluno)");
        }

        
    }

    public void inserirNota(int idDisciplina, double nota, Long matricula) {
        // sql
        String sql = "UPDATE aluno SET nota" + idDisciplina + " = ? WHERE matricula = ?";
    
        try {
            //preparando statement;
            var statement = conn.prepareStatement(sql);
            //setando parametros;
            statement.setDouble(1, nota);
            statement.setLong(2, matricula);
            //executando DML update;
            statement.executeUpdate();
            System.out.println("\n Nota atualizada com sucesso. \n");

        } catch (SQLException e) {
            System.out.println("\n Nao foi possivel inserir a nota do aluno. \n");
        }

    }

    public LinkedList<Aluno> listar() {
        String sql = "SELECT * FROM aluno";
        var lista = new LinkedList<Aluno>();

        //preparando statement;
        try {
            var statement = conn.createStatement();
            //executando query;
            var result = statement.executeQuery(sql);
            //criando objetos aluno
            while (result.next()) {
                var aluno = new Aluno();
                aluno.setMatricula(result.getLong("matricula"));
                aluno.setNome(result.getString("nome"));
                aluno.setNota1(result.getDouble("nota1"));
                aluno.setNota2(result.getDouble("nota2"));
                aluno.setNota3(result.getDouble("nota3"));
                lista.add(aluno);
            }

        } catch (SQLException e) {
            System.err.println("Nao foi possivel listar os alunos");
        }

        return lista;
    }

    public double calculaMediaPorMatricula(Long matricula) throws SQLException {
        double media = 0;
        String sql = "SELECT * FROM aluno WHERE matricula = ?";
        //preparando statement;
        var statement = conn.prepareStatement(sql);
        //setando parametros sql;
        statement.setLong(1, matricula);
        //executando query;
        var result = statement.executeQuery();
        //calculando media;
        if(result.next()){
            media = (result.getDouble("nota1") + result.getDouble("nota2") + result.getDouble("nota3")) /3;
        } else System.err.println("Nao foi possivel calcular a media do aluno.");

        return media;
    }

    

    
}
