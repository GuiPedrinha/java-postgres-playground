package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Estado;

public class EstadoDAO {
    private Connection conn;

    //construtor obrigando receber uma conexao pra instaciar um obj dessa classe;
    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }

    //metodos;
    public void listar() {

        //inicializando statement. sem var agora pq var so intra bloco funciona;
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while (result.next()) {
            System.out.printf("Id: %d Nome: %s UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
            System.out.println();
        //tratamento diferenciando erro de conexao com erro de sintaxe da consulta sql;    
        } catch (SQLException e) {
            System.err.println(" Erro ao realizar o comando query sql ");
            //pode usar System.err.println pra mostrar a msg em vermelho de erro;
        }
    }

    public void localizar(String uf){
        try {
            String sql = "select * from estado where uf = ?";
            // nao usa mais o createStatement, usar o prepareStatement pq recebe um sql como parametro;
            var statement = conn.prepareStatement(sql);
            //setString, pq uf é string, para atribuir o valor de ?;
            // atribuindo a string uf para o parametro ? na posicao 1, que é o primeiro que aparece;
            statement.setString(1, uf);
            // usando prepareStatement o executeQuery nao recebe o sql nos parametros;
            var result = statement.executeQuery();
            System.out.printf("Query: %s \n", sql);
            if(result.next()) {
                System.out.printf("Estado localizado: id: %d nome: %s UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
        } catch (SQLException e) {
            System.err.println("Comando SQL incorreto");
        }
        // pulando linha;
        System.out.println();

    }

    public void inserir(Estado estado) {
        String sql = "INSERT INTO estado (id, nome, uf, regiao_id, area_km2, populacao) VALUES (?, ?, ?, ?, ?, ?)";
        //usar preparestatement quando tiver parametros sql;
        try {
            var statement = conn.prepareStatement(sql);
            //setando paramentros;
            statement.setLong(1, estado.getId());
            
            System.out.printf("%d", estado.getId());
            System.out.println();

            statement.setString(2, estado.getNome());
            System.out.printf("%s", estado.getNome());
            System.out.println();

            statement.setString(3, estado.getUf());
            System.out.printf("%s", estado.getUf());
            System.out.println();

            statement.setLong(4, estado.getRegiao().getId());
            System.out.printf("%d", estado.getRegiao().getId());
            System.out.println();

            statement.setInt(5, estado.getAreaKm2());
            System.out.printf("%d", estado.getAreaKm2());
            System.out.println();

            statement.setInt(6, estado.getPopulacao());
            System.out.printf("%d", estado.getPopulacao());
            System.out.println();


            //rodar com executeUpdate pq é DML = insert, update, delete;
            // == 1 pq espera-se que apenas 1 linha seja modificada na tabela;
            if(statement.executeUpdate() == 1){
                System.out.println("Estado inserido com sucesso");
            }else System.out.println("Nao foi possivel adicionar o estado");

        } catch (SQLException e) {
            System.err.println("Comando SQL incorreto (estado) ");
            System.out.println();
        }
    }

    public void atualizar() {
    }

    public void excluir() {
    }

}
