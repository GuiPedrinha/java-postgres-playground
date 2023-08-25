package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.dao.ConnectionManagerFinanceiro;
import com.example.dao.TransacaoDAO;
import com.example.model.ConversorMoeda;
import com.example.model.CurrencyApi;
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
            var transacao = new Transacao("Guilherme Furtado", 30.00, "EUR", "t");
            
            System.out.println("\n Conexao criado com sucesso \n");

            // CRUD transacao;
            //INSERIR;
            transacaoDAO.inserir(transacao);

            //LISTAR;
            var listaPorCliente = transacaoDAO.listarPorCliente("Guilherme Furtado");
            //visualiza lista filtrada por clientes;
            //System.out.println("\n Listando por cliente:");
            //for (Transacao transacoesCliente : listaPorCliente) {
            //    System.out.println(transacoesCliente);
            //}
            System.out.println();

            var listaPorTipo = transacaoDAO.listarPorTipo("t");
            //visualiza lista filtrada por tipo;
            //System.out.println("\n Listando por tipo de transacao:");
            //for (Transacao transacoesTipo : listaPorTipo) {
            //    System.out.println(transacoesTipo);
            //}

            //PEGAR SALDO E CONVERTER PRA BRL SE PRECISAR
            var saldo = transacaoDAO.getSaldo("Guilherme Furtado");
            System.out.printf("\n O saldo do cliente é de: %.2f \n", saldo);

            System.out.println();

            //CAMBIO DE MOEDAS;
            //var conversorDeMoeda = new ConversorMoeda();
            //var valorConvertido = conversorDeMoeda.cambioReal(230.00, "USD");
            //System.out.printf("\n Resultado do cambio de moeda: %.2f \n\n", valorConvertido);

            //DEVOLVE APENAS O CAMBIO com o metodo static getQuote(from, to);
            //System.out.printf("\n A cotacao é de: %.2f \n\n", CurrencyApi.getQuote("USD", "BRL"));
            


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
