package com.example;

public class AppOperadoresRelacionais {
    
    public static void main(String[] args) {
        
        var cliente1 = new Cliente();
        cliente1.setAnoNascimento(1991);

        var cliente2 = new Cliente();
        cliente2.setAnoNascimento(1993);


        // esse tipo de estrutura tornas os blocos mutuamente exclusivos. nao pode fazer com ifs independentes
        if( cliente1.getAnoNascimento() > cliente2.getAnoNascimento()){
            System.out.println("O cliente 1 é mais novo que o cliente 2");
        }
        else if(cliente1.getAnoNascimento() < cliente2.getAnoNascimento()){
            System.out.println("O cliente 2 é mais novo que o cliente 1");
        }
        else System.out.println("Os dois clientes tem a mesma idade");



    }
}
