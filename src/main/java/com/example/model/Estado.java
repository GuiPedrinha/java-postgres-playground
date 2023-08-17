package com.example.model;

public class Estado {
    //atributos;
    private Long id;
    private String nome;
    private String uf;
    private RegiaoGeografica regiao;
    private int areaKm2;
    private int populacao;
    

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
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public RegiaoGeografica getRegiao() {
        return regiao;
    }
    public void setRegiao(RegiaoGeografica regiao) {
        this.regiao = regiao;
    }
    public int getAreaKm2() {
        return areaKm2;
    }
    public void setAreaKm2(int areaKm) {
        this.areaKm2 = areaKm;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
    @Override
    public String toString() {
        return "Estado [id=" + id + ", nome=" + nome + ", uf=" + uf + "]";
    }
    
}
