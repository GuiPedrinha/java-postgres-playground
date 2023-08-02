package com.example;

public class Cliente {
    private double renda; //atributo private, so a classe pode chamar o cliente.renda direto. outros tem que usar o setter;
    private char sexo;
    private int anoNascimento;

    public double getRenda(){ //public permite que esses atributos sejam acessados por codigo fora do mesmo pacote, se sem nada so acessa de dentro do pacote
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