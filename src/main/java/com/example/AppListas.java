package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Cliente;

public class AppListas {
    public static void main(String[] args) {
        
        //O tipo long e Long(aceita null);

        
        //sintaxe listas; inicializa com o tipo Arraylist e nao List();
        //diferente de vetores, as listas podem ter seu tamanho modificado;
        List<Cliente> listaClientes = new ArrayList<>();

        var lista = new LinkedList<>();

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Carlos");

        var cliente2 = new Cliente();
        cliente2.setNome("Frigatx");

        //adicionar na lista, aceita duplicados;
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        //remover da listpela posicao;
        listaClientes.remove(0);

        //se remover o cliente1, como tem varios, ele vai remover só o primeiro cliente1 que achar;
        listaClientes.remove(cliente1);

        //remover o ultimo elemento da lista;
        //pegar o tamanho da lista e subtrair 1, pq começa no 0 a posicao
        int i = listaClientes.size() - 1;
        listaClientes.remove(i);

        //impressao de uma lista de objetos usando o toString automaticamente do objeto;
        // ja chama direto o toString implementado dentro do objeto;
        System.out.println(listaClientes);
        System.out.println();

        // uma forma melhor é usar o for each - estrutura pronta;
        // ele cria uma var local com o tipo do objeto;
        // quando sysout usar a variavel que ele criou pra armazenar cada obj;
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }


    }
}
