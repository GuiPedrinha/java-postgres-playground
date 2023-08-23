package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.dao.ConnectionManagerFinanceiro;
import com.example.dao.TransacaoDAO;
import com.example.model.Transacao;

public class AppFinanceiro {
    public static void main(String[] args) {
        new AppFinanceiro();
    }

    //construtor app financeiro;
    public AppFinanceiro(){
        // carregando driver jdbc;
        carregarDriver();
        //criando conexao auto closable;
        try (var conn = ConnectionManagerFinanceiro.getConnection()) {
            //criando nova transacao;
            var transacaoDAO = new TransacaoDAO(conn);
            var transacao = new Transacao("Bruna chata linda", 20.00, "BRL", "t");
            
            System.out.println("\n Conexao criado com sucesso \n");

            // CRUD transacao;
            //transacaoDAO.inserir(transacao);

             
            var listaPorCliente = transacaoDAO.listarPorCliente("Bruna chata linda");

            //visualiza lista filtrada por clientes;
            for (Transacao transacoesCliente : listaPorCliente) {
                System.out.println(transacoesCliente);
            }
            


            //var listaPorTipo = transacaoDAO.listarPorTipo("t");




        } catch (SQLException e) {
            System.err.println("\n Nao foi possivel criar uma conexao com o Bando de dados." + e + "\n");
        }  
    }

    //carregar biblioteca BD;
    public void carregarDriver () {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("\n Driver jdbc carregado com sucesso.\n");
        } catch (ClassNotFoundException e) {
            System.err.println("\n O driver nao pode ser carregado." + e + "\n");
        }
    }
    

}
