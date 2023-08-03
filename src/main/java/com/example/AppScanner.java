package com.example;

import java.util.Scanner;

public class AppScanner {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();// instaciana de um novo objetivo do tipo cliente

        //Usando a classe scanner com parametro system.in para captura entrada padrao que é o teclado;
        // quando chamado ele fica esperando o usuario digitar;
        Scanner scanner = new Scanner(System.in); 

        // msg pro usuario digitar, armazena no scanner e passa como parametro(scanner.nextLine) pro setname;
        System.out.println("Digite o nome: ");
        //scanner.nextLine é pra retornar um tipo String, nao daria pra usar na renda por ex;
        cliente1.setNome(scanner.nextLine());

        System.out.println("Digite o CPF: ");
        cliente1.setCpf(scanner.nextLine());

        //scanner.nextDouble() para retornar valores double, por ex na renda; tem pra todos os tipos primitivos;
        System.out.println("Digite a renda: ");
        cliente1.setRenda(scanner.nextDouble());

        System.out.println("Digite o ano de nascimento: ");
        cliente1.setanoNascimento(scanner.nextInt());

        //scanner.nextLine apenas pra capturar o enter em espera que nao entrou no nextInt/nextDouble;
        scanner.nextLine();
        // aqui o campo sexo é char, nao aceita receber uma string, para isso precisa passar so o primeiro char da string ou seja posicao 0;
        // entao pegar o digitado, colocar numa string passar o primeiro char pro setSexo;
        System.out.println("Digite o sexo M ou F: ");
        String sexo = (scanner.nextLine());
        cliente1.setSexo(sexo.charAt(0));

        // **** IMPORTANTE *****;
        // ; problema: ter um nextInt precedendo um nextLine;
        // Quando se set um scanner.nextInt, ao terminar de digitar e apertar ENTER essa tecla nao é
        // armazenada no nextInt e fica a espera de um proximo nextLine;
        // vai acabar sendo lida imediatamente pelo proximo nextLine impedindo que o usuario digite algo;
        // no caso vai pular a opcao de digitar o sexo;
        // p/ reseolver basta colocar uma nextLine vazio olog depois de um nextInt, que ai vai ler o ENTER a espera;
        //.
        // OU apenas colcoar tudo que for string pra ser captura antes que qualquer dado diff de string.


        


        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("Renda: " + cliente1.getRenda());
        System.out.println("Sexo: " + cliente1.getSexo());
        System.out.println("Nascimento: " + cliente1.getanonascimento());
        System.out.println("Especial: " + cliente1.isEspecial());
        
    }
}

