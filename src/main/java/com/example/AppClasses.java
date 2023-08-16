package com.example;

import com.example.model.Cliente;

public class AppClasses {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();// instaciana de um novo objetivo do tipo cliente
        cliente1.setCpf("99999999999");
        cliente1.setNome("Tarkone Mosin Santos BP");
        cliente1.setRenda(15000);
        cliente1.setSexo('M');
        cliente1.setanoNascimento(1993);

        //caso de uso do split() retornando uma vetor e usando var pra reserver o tipo String[] automaticamente;
        var vetorNome = cliente1.getNome().split(" ");
        System.out.println(vetorNome[0] + " " + vetorNome[1]);

        //caso de uso do charAt() para pegar o char em determinada posicao da String
        var posicaoChar = cliente1.getNome().charAt(0);
        System.out.println("o Char na posicao 0 é: " + posicaoChar);

        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("Renda: " + cliente1.getRenda());
        System.out.println("Sexo: " + cliente1.getSexo());
        System.out.println("Nascimento: " + cliente1.getanonascimento());
        System.out.println("Especial: " + cliente1.isEspecial());

        Cliente cliente2 = new Cliente("Ak47",20000,'F');
        cliente2.setCpf("99999999990");

        System.out.println("Nome: " + cliente2.getNome());
        System.out.println("Renda: " + cliente2.getRenda());
        System.out.println("Sexo: " + cliente2.getSexo());
        System.out.println("Nascimento: " + cliente2.getanonascimento());
        System.out.println("Especial: " + cliente2.isEspecial());

        // nao usar == para comparar strongs. nao funciona. usar .equals server para comparar conteudos, NAO SO STRINGS!
        if(cliente1.getCpf().equals(cliente2.getCpf())){
            System.out.println("os cps sao iguais!");
        }else System.out.println("cpfs distintos");;
        
    }
}
