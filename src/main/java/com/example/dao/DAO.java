package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
    //atributos;
    Connection conn;

    //construtor;
    public DAO(Connection conn){
        this.conn = conn;
    }

    //metodos;
    public void listarTabelas() {
        var sql = "SELECT table_name FROM information_schema.tables WHERE table_schema='public'";
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);

            System.out.printf("%s \n", sql);
            while (result.next()) {
                System.out.printf("%s \n", result.getString("table_name"));
            }
        } catch (SQLException e) {
            System.err.println("Erro de consulta SQL " + e.getMessage());
        }

    }

    public void listarDadosTabela(String tabela) {
            // aqui pode concatenar oq nao é dado inserido por usuario;
            var sql = "select * from " + tabela;
            System.out.printf("Query: %s \n", sql);
            System.out.println();

            try {
                // como nao teve ? no sql ,usar o conn.createStatement normalmente, passa sql como parametro pro execute;
                var statement = conn.createStatement();
                var result = statement.executeQuery(sql);

                //criado para simplificar e chamar so uma vez;
                //result.getMetaData.getColumCount e name;
                var metadata = result.getMetaData();
                int colunas = metadata.getColumnCount();

                System.out.println();
                System.out.printf("A contagem de colunas da tabela %s é: %d", tabela, colunas);
                System.out.println();

                // *** printando nome das colunas; LEMBRAR i começa em 1 no SQL *** ;
                for (int i = 1; i <= colunas; i++) {
                    System.out.printf("%-25s ", metadata.getColumnName(i));
                }
                System.out.println();

                // precisa de for pq vamos printar todas as colunas de cada linha;
                // result.next() vai p/ cada linha e o for pra cada coluna na linha;
                while (result.next()) {
                    // devolve o numero de colunas de cada linha pra usar dentro do for;
                    // ** no sql i começa com 1 e nao com zero, pq é indice de coluna;
                    for (int i = 1; i <= colunas; i++) {
                        //trazer tudo em string so pra visualizar as tabelas, pela getString(index);
                        System.out.printf("%-25s ", result.getString(i));
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                System.err.println("Erro de consulta SQL: " + e.getMessage());
            }
            System.out.println();
        }
}
