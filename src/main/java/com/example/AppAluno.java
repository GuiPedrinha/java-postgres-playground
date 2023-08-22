package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
            //aluno.setNome("Belinha");
            aluno.setMatricula(2L);

            //CRUD obj aluno na tabela;
            //alunoDAO.inserir(aluno);
            //alunoDAO.inserirNota(3, 10, aluno.getMatricula());
            List<Aluno> listaAluno = alunoDAO.listar();   
            
            //visualizando lista;
            for (Aluno alunoObject : listaAluno) {
                System.out.println(alunoObject);
            }

            //calcula media;
            var mediaALuno = alunoDAO.calculaMediaPorMatricula(aluno.getMatricula());
            //visualizando media;
            System.out.printf("\n A media do aluno de matricula %d é: %.2f \n", aluno.getMatricula(), mediaALuno);


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
