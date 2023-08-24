package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    public List<Transacao> listarPorCliente(String cliente) {
        var listaPorCliente = new LinkedList<Transacao>();
        //consulta sql;
        String sql = "SELECT * FROM transacao WHERE cliente = ?";
    
        try {
            //preparar statement;
            var statement = conn.prepareStatement(sql);

            //setar parametro;
            statement.setString(1, cliente);

            //executar consulta;
            var result = statement.executeQuery();

            //criando lista de objetos;
            while (result.next()) {
                var transacao = new Transacao(
                    result.getString("cliente"),
                    result.getDouble("valor"),
                    result.getString("moeda"),
                    result.getString("tipo")
                    );
                transacao.setId(result.getInt("id_transacao"));
                listaPorCliente.add(transacao);  
            }

        } catch (SQLException e) {
            System.err.println("Nao foi possivel listar transacoes por cliente.");
        }
        return listaPorCliente;
    }



    public List<Transacao> listarPorTipo(String tipo) {

        var listaPorTipo = new LinkedList<Transacao>();
        //consulta sql;
        String sql = "SELECT * FROM transacao WHERE tipo = ?";
    
        try {
            //preparar statement;
            var statement = conn.prepareStatement(sql);

            //setar parametro;
            statement.setString(1, tipo);

            //executar consulta;
            var result = statement.executeQuery();

            //criando lista de objetos;
            while (result.next()) {
                var transacao = new Transacao(
                    result.getString("cliente"),
                    result.getDouble("valor"),
                    result.getString("moeda"),
                    result.getString("tipo")
                    );
                transacao.setId(result.getInt("id_transacao"));
                listaPorTipo.add(transacao);  
            }

        } catch (SQLException e) {
            System.err.println("Nao foi possivel listar transacoes por cliente.");
        }
        return listaPorTipo;
    }
    
}
