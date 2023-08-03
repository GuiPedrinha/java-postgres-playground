package com.example;

public class Cliente {
    private double renda; //atributo private, so a classe pode chamar o cliente.renda direto. outros tem que usar o setter;
    private char sexo;
    private int anoNascimento;
    private boolean especial;
    
    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    //getEspecial
    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    //construtor sem parametro;
    public Cliente(){
        System.out.println("\n" + "criando cliente com construtor sem parametro");
        double aleatorio = Math.random();
        if(aleatorio > 0.5){
            this.especial = true; 
        };
    };

    //construtor com parametro; que chama o construtor mais simples e adiciona funcionalidades
    public Cliente(double renda, char sexo){

        // OBRIGATORIO SER A PRIMEIRA LINHA;
        //assim se chama construtor dentro de construtor, se diferenciam pelos parametros colocados nos this. sem parametro chama o constr. sem parametro;
        this(); 
        System.out.println("\n" + "criando cliente com construtor COM parametro");

        //chamando os sets sem copiar as logicas de validacao aqui novamente!!;
        setRenda(renda);
        setSexo(sexo);
    };

    //public permite que esses atributos sejam acessados por codigo fora do mesmo pacote, se sem nada so acessa de dentro do pacote
    public double getRenda(){ 
        return renda;
    };

    public char getSexo(){
        return sexo;
    };

    public int getanonascimento(){
        return anoNascimento;
    };

    public void setRenda(double renda){
        if(renda>=0){
            this.renda = renda;
        }
        else System.out.println("Input inadequado!"); 
    };

    public void setSexo(char sexo){
        if(sexo == 'M' || sexo == 'F'){
            this.sexo = sexo;
        }
        else System.out.println("Escreva M ou F");
    };

    public void setanoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    };

}