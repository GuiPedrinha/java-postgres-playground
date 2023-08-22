package com.example.model;

public class Aluno {
    //atributos;
    private Long matricula;
    private String nome;
    private double nota1, nota2, nota3;

    //construtor;

    
    //metodos;
    // inicio getters and setters;
    public Long getMatricula() {
        return matricula;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    public double getNota3() {
        return nota3;
    }
    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
    public double calculaMedia() {
        double media = (nota1 + nota2 + nota3)/3;
        return media;
    }


    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome=" + nome + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3="
                + nota3 + "]";
    }
    // fim getters and setters;

    
}
