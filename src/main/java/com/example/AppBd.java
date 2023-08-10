package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class AppBd {
    public static void main(String[] args) {
        
        // conectando ao driver do BD; parametro em aspas. String;
        //precisa tratar erro com try catch;
        //usar opcao quick fix; surround with try catch;
        // evitar aninhamento triplo! try try while sera arrumado NO ARQUIVO ARRUMADO;
        try {
            Class.forName("org.postgresql.Driver");

            //tbm precisa tratar com try catch;
            //aqui entra um try especial com parametro;
            //usar isso quando precisar fechar uma conexao com o banco;
            //entao dentro dele que sera feita a declaracao da variavel conn pra fechar depois;
            //precisa fechar toda conexao de banco pra economizar recursos;
            try(var conn =  DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "");){
                //DriverManager.getConnection devolve um objeto do tipo cannection;
                //variavel conn so acessivel dentro desse bloco try;
                // tipo var so funciona dentro de blocos!!!;
                //abaixo foi movido pra dentro do try();
                //var conn =  DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "");

               //se chegou aqui conseguiu conectar;
               System.out.println("Conexao com o banco de dados realizada com sucesso!");

               //criar um objeto statemente pra conseguir enviar comandos ao banco a partir dele;
               var statement = conn.createStatement();
               //.executeQuery é para mandar comandos de CONSULTA;
               // ele devolve um objeto resultSet que contem as linhas da tabela;
               var result = statement.executeQuery("select * from estado");

               //printar as linhas dentro de um laço while usando result.next();
               // vai parar de printar quando next for false;
               while (result.next()) {
                //usar printf ao inves de ln pra evitar concatenaoçao;
                // %d imprime conteudo de variavel inteiro (id);
                // %s imprime string;
                // usar get.Int(pegar o campo id string pq é nome da coluna e vem em int);
                // .getString(nome e uf e vem em string);
                // pode verificar nos nomes das colunas na aba do banco de dados na esquerda;
                // colocar as variaveis na ordem quem que aparecem os %;
                System.out.printf("Id: %d Nome: %s UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
               }

               

            } catch (SQLException e) {
                //pode usar System.err.println pra mostrar a msg em vermelho de erro;
                System.err.println("Nao foi possivel conectar ao banco de dados" + e.getMessage());
            }

        //so entra no catch se der algum erro e nada o try será executado;
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel carregar o banco de dados" + e.getMessage());
        }
    }
}
