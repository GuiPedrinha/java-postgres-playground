package com.example.model;

// classe produto criada pra poder inserir um objeto produto dentro do banco;

public class Produto {
    //atributos;
    private Long id;
    private String nome;
    //feito assim pois é um id_marca no banco. que linka com outro objeto marca;
    private Marca marca;
    private double valor;

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
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double d) {
        this.valor = d;
    }

}
