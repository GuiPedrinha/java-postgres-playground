package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Marca;
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

    public List<Produto> listar() throws SQLException {
        var lista = new LinkedList<Produto>();
        var marcaDAO = new MarcaDAO(conn);
        String sql = "SELECT * FROM produto";
        // n vou usar ? entao createstatement normal;
        //criar statement;
        var statement = conn.createStatement();
        //executastatement
        var result = statement.executeQuery(sql);

        while (result.next()) {
            var produto = new Produto();
            produto.setId(result.getLong("id"));
            produto.setNome(result.getString("nome"));
            produto.setMarca(marcaDAO.produraPorId(result.getLong("marca_id")));
            produto.setValor(result.getDouble("valor"));
            lista.add(produto);
            }

        // Produto [id=" + id + ", nome=" + nome + ", mar=" + marca + ", val=" + valor + "]"

        return lista;
        

    } 
 



    
}
