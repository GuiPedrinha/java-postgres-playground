package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Transacao;

public class TransacaoDAO {
    //atributos;
    private Connection conn;

    //construtor;
    public TransacaoDAO(Connection conn){
        this.conn = conn;
    }

    //metodos;
    public void inserir(Transacao transacao) {
        String sql = "INSERT INTO transacao (cliente, valor, moeda, tipo) VALUES (?, ?, ?, ?)";
        //preparar o statement;
        try {
            var statement = conn.prepareStatement(sql);
            //setando parametros;
            statement.setString(1, transacao.getCliente());
            statement.setDouble(2, transacao.getValor());
            statement.setString(3, transacao.getMoeda());
            statement.setString(4, transacao.getTipo());
            //executando statement;
            if (statement.executeUpdate() == 1)
                System.out.println("Transacao adicionada com sucesso.");

        } catch (SQLException e) {
            System.err.println("Nao foi possivel inserir a transacao.)");
        }
        
        

    }
}
