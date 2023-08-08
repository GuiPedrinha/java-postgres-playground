package com.example;

import java.util.Scanner;

public class Eleitor {

    //atributos
    private int idade;
    
    //construtores
    Eleitor(){
        //inicializando classe scanner para informar a idade do eleitor;
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Digite a idade do eleitor: ");
        this.idade = scanner.nextInt();
        System.out.println();

        //capturando enter restante;
        scanner.nextLine();
    }
    
    //metodos
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String tipoEleitor(){
        String tipoEleitor;
        //nao = < 16 anos,
        // facultativo =  > 15 e < 18, ou > 70
        // obrigatorio = maior ou igual a 18 e menor ou igual a 70
        if(this.idade < 16){
            tipoEleitor = "nao eleitor";
        }
        else if(this.idade >= 16 && this.idade < 18 || this.idade > 70){
            tipoEleitor = "Eleitor facultativo";
        }
        else tipoEleitor = "Eleitor obrigatorio";

        return tipoEleitor;
        
    }
}