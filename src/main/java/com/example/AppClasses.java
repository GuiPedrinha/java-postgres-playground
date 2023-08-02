package com.example;


public class AppClasses {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();// instaciana de um novo objetivo do tipo cliente
        cliente1.setRenda(15000);
        cliente1.setSexo('M');
        cliente1.setanoNascimento(1993);

        System.out.println();
        System.out.println("Renda: " + cliente1.getRenda());
        System.out.println("Sexo: " + cliente1.getSexo());
        System.out.println("Nascimento: " + cliente1.getanonascimento());
        
    }
}
