package com.example.model;

public class Marca {
    //atributos;
    private Long id;
    private String nome;
    

    //construtor;

    //metodos;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "[id=" + id + "]";
    }
   
    
}