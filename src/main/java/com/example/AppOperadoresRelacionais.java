package com.example;

public class AppOperadoresRelacionais {
    
    public static void main(String[] args) {
        
        var cliente1 = new Cliente();
        cliente1.setAnoNascimento(1991);

        var cliente2 = new Cliente();
        cliente2.setAnoNascimento(1993);


        // condicoes muitos grades no If sao uma ma pratica
        // "if( cliente1.getAnoNascimento() > cliente2.getAnoNascimento())"
        // alem de precisar alterar muita coisa no caso de um erro
        // O certo é guardar o valor em uma variavel booleana da condicao e usar no If
        // pq no if é uma condicao que tem valor verdadeiro ou falso = boolean;

        boolean clienteMaisJovem = cliente1.getAnoNascimento() > cliente2.getAnoNascimento();
        boolean clienteMaisVelho = cliente1.getAnoNascimento() < cliente2.getAnoNascimento();

        // esse tipo de estrutura tornas os blocos mutuamente exclusivos. nao pode fazer com ifs independentes
        if(clienteMaisJovem){
            System.out.println("O cliente 1 é mais novo que o cliente 2");
        }
        else if(clienteMaisVelho){
            System.out.println("O cliente 2 é mais novo que o cliente 1");
        }
        else System.out.println("Os dois clientes tem a mesma idade");



    }
}
