package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import com.example.model.Estado;

public class EstadoDAO extends DAO{
    // construtor obrigando receber uma conexao pra instaciar um obj dessa classe;
    // mas como extends de DAO entao esse paramentro conecction vem do DAO base/pai;
    
    public EstadoDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    // metodos;
    // retorna uma lista de objetos;
    public List<Estado> listar() throws SQLException {
        var lista = new LinkedList<Estado>();
        // inicializando statement. sem var agora pq var so intra bloco funciona;
        var statement = conn.createStatement();
        var result = statement.executeQuery("select * from estado");
        while (result.next()) {
            // instaciar 1 estado para cada loop, por isso dentro;
            var estado = new Estado();
            estado.setId(result.getLong("id"));
            estado.setNome(result.getString("nome"));
            estado.setUf(result.getString("uf"));
            lista.add(estado);
        }
        return lista;
    }

    public Estado localizar(String uf) throws SQLException {
        String sql = "select * from estado where uf = ?";
        // nao usa mais o createStatement, usar o prepareStatement pq recebe um sql como
        // parametro;
        var statement = conn.prepareStatement(sql);
        // setString, pq uf é string, para atribuir o valor de ?;
        // atribuindo a string uf para o parametro ? na posicao 1, que é o primeiro que
        // aparece;
        statement.setString(1, uf);
        // usando prepareStatement o executeQuery nao recebe o sql nos parametros;
        var result = statement.executeQuery();
        var estado = new Estado();
        
        if (result.next()) {
            estado.setId(result.getLong("id"));
            estado.setNome(result.getString("nome"));
            estado.setUf(result.getString("uf"));
        }
        return estado;
    }

    public void inserir(Estado estado) {
        String sql = "INSERT INTO estado (id, nome, uf, regiao_id, area_km2, populacao) VALUES (?, ?, ?, ?, ?, ?)";
        // usar preparestatement quando tiver parametros sql;
        try {
            var statement = conn.prepareStatement(sql);
            // setando paramentros;
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

            // rodar com executeUpdate pq é DML = insert, update, delete;
            // == 1 pq espera-se que apenas 1 linha seja modificada na tabela;
            if (statement.executeUpdate() == 1) {
                System.out.println("Estado inserido com sucesso");
            } else
                System.out.println("Nao foi possivel adicionar o estado");

        } catch (SQLException e) {
            System.err.println("Comando SQL incorreto (estado) ");
            System.out.println();
        }
    }

    public void alterar(Estado estado) {
        String sql = "UPDATE estado SET nome = ?, uf = ?, regiao_id = ?, area_km2 = ?, populacao = ? WHERE id = ?";
        try {
            // preparando statement;
            var statement = conn.prepareStatement(sql);

            // setando parametros sql;
            statement.setString(1, estado.getNome());
            statement.setString(2, estado.getUf());
            statement.setLong(3, estado.getRegiao().getId());
            statement.setInt(4, 999);
            statement.setInt(5, 5600);
            statement.setLong(6, estado.getId());

            // executando;
            if (statement.executeUpdate() == 1) {
                System.out.println("Estado alterado com sucesso.");
            } else
                System.out.println("O estado nao pode ser alterado");

        } catch (SQLException e) {
            System.err.println("Comando SQL incorreto (alterar estado)");
            System.out.println();
        }
    }

    public void excluir(Estado estado) {
        String sql = "DELETE FROM estado WHERE id = ?";

        try {
            // preparar statement;
            var statement = conn.prepareStatement(sql);

            // setando parametro ?;
            statement.setLong(1, estado.getId());

            // executando;
            if (statement.executeUpdate() == 1) {
                System.out.println("Estado excluído com sucesso");
            } else
                System.out.println("Nao foi possivel excluir o estado");

        } catch (SQLException e) {
            System.err.println("Nao foi possivel executar o comando SQL (excluir estado)");
            System.out.println();
        }

    }

}
