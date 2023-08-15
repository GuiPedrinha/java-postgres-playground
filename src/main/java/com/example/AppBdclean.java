package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.Driver;

public class AppBdclean {
    //refatorado extract to constraint; o "final" quer dizer isso;
    //constantes sao sempre UPPERCASE;
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";


    public static void main(String[] args) {
        //chamando apenas o construtor;
        new AppBdclean();
    }

    // tirar os statics, passar tudo pra uns constrututor pra fazer só 1 vez;
    // passando o tratamento da conexao tbm pra dentro do construtor;
    public AppBdclean(){
        try (var conn =  getConnection()){
            carregarDriverJDBC(conn);
            listaEstados(conn);
            localizarEstado(conn, "TO");

            //inserir produto na tabela;
            //instanciando as classes produto e marca;
            var marca = new Marca();
            // vai ser da marca de id 1;
            marca.setId(1L); //L so pra dizer que n é int, é Long; n precisa nome pra add na tabela produto;
            var produto = new Produto();
            produto.setMarca(marca);
            produto.setNome("AK-47");
            produto.setValor(23000.00);

            inserirProduto(conn, produto);

            excluirProduto(conn, 202L);

            //listando colunas da tabela cliente;
            listaDadosTabela(conn, "produto");
            listaTabelas(conn);

        } catch (SQLException e) {
            //unico erro que o construc vai ter ciencia é o de conexao;
            // os outros ainda sao tratados em quem chamar o listarEstados;
                System.err.println(" Nao foi possivel conectar ao banco de dados " + e.getMessage());
        }
    }

    private void excluirProduto(Connection conn, long id) {

        String sql = "DELETE FROM produto WHERE id = ?";
        try {
            //preparar statement
            var statement = conn.prepareStatement(sql);

            //setar parametros ?;
            statement.setLong(1, id);

            //executando DML;
            statement.executeUpdate();


        } catch (SQLException e) {
            System.err.println("O comando SQL está incorreto");
        }
        

        }

    private void inserirProduto(Connection conn, Produto produto) {

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
                statement.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Comando SQL incorreto");
            }

        }

    private void listaTabelas(Connection conn) {
            var sql = "SELECT table_name FROM information_schema.tables WHERE table_schema='public'";
            try {
                var statement = conn.createStatement();
                var result = statement.executeQuery(sql);

                System.out.printf("%s \n", sql);
                while (result.next()) {
                    System.out.printf("%s \n", result.getString("table_name"));
                }
            } catch (SQLException e) {
                System.err.println("Erro de consulta SQL " + e.getMessage());
            }

        }

    private void listaDadosTabela(Connection conn, String tabela) {
            // aqui pode concatenar oq nao é dado inserido por usuario;
            var sql = "select * from " + tabela;
            System.out.printf("Query: %s \n", sql);
            System.out.println();

            try {
                // como nao teve ? no sql ,usar o conn.createStatement normalmente, passa sql como parametro pro execute;
                var statement = conn.createStatement();
                var result = statement.executeQuery(sql);

                //criado para simplificar e chamar so uma vez;
                //result.getMetaData.getColumCount e name;
                var metadata = result.getMetaData();
                int colunas = metadata.getColumnCount();

                System.out.println();
                System.out.printf("A contagem de colunas da tabela %s é: %d", tabela, colunas);
                System.out.println();

                // *** printando nome das colunas; LEMBRAR i começa em 1 no SQL *** ;
                for (int i = 1; i <= colunas; i++) {
                    System.out.printf("%-25s ", metadata.getColumnName(i));
                }
                System.out.println();

                // precisa de for pq vamos printar todas as colunas de cada linha;
                // result.next() vai p/ cada linha e o for pra cada coluna na linha;
                while (result.next()) {
                    // devolve o numero de colunas de cada linha pra usar dentro do for;
                    // ** no sql i começa com 1 e nao com zero, pq é indice de coluna;
                    for (int i = 1; i <= colunas; i++) {
                        //trazer tudo em string so pra visualizar as tabelas, pela getString(index);
                        System.out.printf("%-25s ", result.getString(i));
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                System.err.println("Erro de consulta SQL: " + e.getMessage());
            }
            System.out.println();
        }

    private void localizarEstado(Connection conn, String uf){
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

    private void listaEstados(Connection conn) {

            // agora sao trys independentes; refatorar em metodos separados;
            //p/ saber se erro foi na conexao ou no comando sql declarar variavel statment fora do bloco;
            // cuidado com imports. é statement sql nao beans;
            //inicializando statement. sem var agora pq var so intra bloco funciona;
            //REFATORADO - apos pronto refactor -> extract to method;

            try {
                System.out.println("Conexao com o banco de dados realizada com sucesso!");
                
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

    // foi refatorado pq sempre vai ser chamado isso pra criar uma conexao;
    // usou throws para delegar o tratamento dessa conexao ao metodo que chamar este;
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void carregarDriverJDBC(Connection conn) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel carregar o banco de dados" + e.getMessage());
        }
    }
}
