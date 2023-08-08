package com.example;


public class AppOpLogicos {

    // metodos so pra ver qual expressoes foram realmente avaliadas;
    boolean a(boolean valor){
        System.out.println("a");
        return valor;
    }
    
    boolean b(boolean valor){
        System.out.println("b");
        return valor;
    }
    
    boolean c(boolean valor){
        System.out.println("c");
        return valor;
    }

    // construtor para pode chamar os metodos que nao sao statics. pq o main é static
    // construtor tem o nome da classe sem retorno
    AppOpLogicos(){
        System.out.println(a(true) && b(true) || c(false));
        //nesse exemplo nao é chamado o metodo c(); pq como é um OU e a primeira parte ja deu true, entao é true
    }

    public static void main(String[] args) {
        
        //dentro de classes staticas so pode chamar funcoes statics OU chamando o construtor;
        //chamando construtor; pra criar um objeto da classe. nao armazena em nada.
        // é so pra poder chamar os metodos nao statics; usar static so em excecoes
        new AppOpLogicos();

    }
}
