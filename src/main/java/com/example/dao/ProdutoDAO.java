package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO {
    //atributos;
    private Connection conn;

    //construtor;
    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    //metodos;
    public void inserir(Produto produto) {

        // em objetos nao se usa o nome com underline tipo marca_id;
        //cria-se um atributo do tipo Marca marca e ai sim seta o id dentro desse novo obj marca;
        //diferente do nome que vai no sql que é o nome da coluna msm do banco; sendo marca_id;
        //marca_id equivale a produto.getMarca().getId();
        String sql = "INSERT INTO produto (nome, marca_id, valor) VALUES (?, ?, ?)";
        try {
            var statement = conn.prepareStatement(sql);
            //setando o valor das variaveis;
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());

            //tudo setado agora executar; mas nao com executeQuery e sim com executeUpdate;
            //executeUpdate serve para comandos DATA MANIPULATION LANG = INSERT UPDATE DELETE;
            //como usou o conn.prepareStatement(sql) nao vai paramentro dentro do statemente.executeUpdate();
            if(statement.executeUpdate() == 1)
                System.out.println("Produto inserido com sucesso!");
            else System.out.println("O poduto nao foi inserido.");
            System.out.println();
            
        } catch (SQLException e) {
            System.err.println("Comando SQL incorreto (produto)");
            System.out.println();
        }

    }

    public void alterar(Produto produto) {
        //tem que ter id no produto;
        String sql = "UPDATE produto SET nome = ?, marca_id = ?, valor = ? WHERE id = ?";
            try {
                var statement = conn.prepareStatement(sql);
                //setando o valor dos parametros ? ;
                statement.setString(1, produto.getNome());
                statement.setLong(2, produto.getMarca().getId());
                statement.setDouble(3, produto.getValor());
                statement.setLong(4, produto.getId());

                //executando statement;
                statement.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Comando SQL incorreto");
            }
    }

    public void excluir(long id) {
        String sql = "DELETE FROM produto WHERE id = ?";
            try {
                //preparar statement
                var statement = conn.prepareStatement(sql);

                //setar parametros ?;
                statement.setLong(1, id);

                //executando DML;
                // executeUpdate retorna tbm o numero de linhas que foram afetadas;
                // como estamos excluindo so 1 produto vai alterar um. usar isso pra ter msgs de sucesso;
                if(statement.executeUpdate() == 1)
                    System.out.println("Produto excluido com sucesso");
                else System.out.println("Produto nao localizado no banco"); 
                System.out.println();

                } catch (SQLException e) {
                System.err.println("O comando SQL está incorreto");
            }

        }




    
}
