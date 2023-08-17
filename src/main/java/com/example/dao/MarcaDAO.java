package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Marca;

public class MarcaDAO extends DAO{
    //atributos;

    //construtor;
    
public MarcaDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }


    //metodos;
    public Marca produraPorId(Long id) throws SQLException{
        String sql = "SELECT * FROM marca WHERE id = ?";
        //tem paramentro entao prepareStatement;
        var statement = conn.prepareStatement(sql);
        //setando parametro;
        statement.setLong(1, id);
        //executar statement;
        var result = statement.executeQuery();
        //criando obj:
        Marca marca = new Marca();
        if (result.next()) {
            marca.setId(result.getLong("id"));
            marca.setNome(result.getString("nome"));
        }

        return marca;
    }
}
