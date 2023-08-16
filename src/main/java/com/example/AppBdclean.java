package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.Driver;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Estado;
import com.example.model.Marca;
import com.example.model.Produto;
import com.example.model.RegiaoGeografica;

public class AppBdclean {
    public static void main(String[] args) {
        //chamando apenas o construtor;
        new AppBdclean();
    }

    // tirar os statics, passar tudo pra uns constrututor pra fazer só 1 vez;
    // passando o tratamento da conexao tbm pra dentro do construtor;
    public AppBdclean(){
        try (var conn =  ConnectionManager.getConnection()){
            carregarDriverJDBC();
            
            //CRUD ESTADO;
            //instanciando objetos;
            var estadoDAO = new EstadoDAO(conn);
            var estado = new Estado();
            var regiao = new RegiaoGeografica();
            regiao.setId(4L);

            //populando obj estado e regiao;
            estado.setId(30L); //*obrigatorios diferentes e NAO AUTOINCREMENTA */
            estado.setNome("Factorysss");//* obrigatorios diferentes*/
            estado.setUf("FS");//* obrigatorios diferentes */
            estado.setRegiao(regiao);
            estado.setAreaKm2(2500);
            estado.setPopulacao(7);

            estadoDAO.inserir(estado);
            //estadoDAO.atualizar();
            //estadoDAO.excluir();
            //estadoDAO.listar();
            //estadoDAO.localizar("TO");



            // CRUD PRODUTO;
            //inserir produto na tabela;
            //instanciando as classes produto e marca;
            var marca = new Marca();
            // vai ser da marca de id 1;
            marca.setId(3L); //L so pra dizer que n é int, é Long; n precisa nome pra add na tabela produto;

            var produto = new Produto();
            //produto.setId(206L);
            produto.setMarca(marca);
            produto.setNome("Escape from tarkov EOD");
            produto.setValor(850.00);

            var produtoDAO = new ProdutoDAO(conn);
            //produtoDAO.inserir(produto);
            //produtoDAO.alterar(produto);
            //produtoDAO.excluir(208L);
            //listando colunas da tabela cliente;
            
            //DAO GERNERICO;
            var dao = new DAO(conn);
            dao.listarDadosTabela("estado");
            //dao.listarTabelas();

        } catch (SQLException e) {
            //unico erro que o construc vai ter ciencia é o de conexao;
            // os outros ainda sao tratados em quem chamar o listarEstados;
                System.err.println(" Nao foi possivel conectar ao banco de dados " + e.getMessage());
        }
    }


    private void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel carregar o banco de dados" + e.getMessage());
        }
    }
}
