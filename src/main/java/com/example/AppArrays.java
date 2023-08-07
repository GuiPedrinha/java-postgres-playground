package com.example;

import java.util.Arrays;

public class AppArrays {

    public static void main(String[] args) {
        
        // inicializar defindindo valor;
        double vetor1[] = {1, 2, 3, 4};
        double vetor2[] = {5, 25, 35, 45};

        // p funiconar precisam ser do mesmo tipo. diferente das var primitivas;
        vetor2 = vetor1; 


        System.out.println(Arrays.toString(vetor2));

        // inicializar sem definir valor, so tamanho;
        int vetorInt[] = new int[4]; 

        // matriz de 2 linhas e 3 colunas;
        double matriz[][] = { {2, 3, 4}, {5, 5, 5} };
        System.out.println(Arrays.toString(matriz[0]));
        System.out.println(Arrays.toString(matriz[1]));

        matriz[1][2] = 99;
        System.out.println(Arrays.toString(matriz[1]));// Printa toda a linha 1 da matriz;

        //mudar linha 1 toda;
       // matriz[1] = {1,2,3}; isso so funciona na declaracao, nao pra atualizar valor;
       matriz[1] = new double[]{1,2,3}; //adicionando um novo vetor a linha 1 da matriz;

       // as linhas d euma matriz nao precisam ter o mesmo tamanha, ou seja nao precisam ter o mesmo numero de colunas;

        //matriz com for

        double matrizFor[][] = new double[3][4];

        //fori ja da autocomplete na estrutura completa do for;
        for (int i = 0; i < matrizFor.length; i++) {
            for (int j = 0; j < matrizFor.length; j++) {
                matrizFor[i][j] = (i * matrizFor.length + j) * 10;
            }
       }

        for (int i = 0; i < matrizFor.length; i++) {
            for (int j = 0; j < matrizFor.length; j++) {
                System.out.print(matrizFor[i][j] + " "); // nao pode ser print ln pq se imprime tudo como se fosse inuca coluna
            }
         System.out.println();//pula linha ao fim das colunas;
        }

    }
}
