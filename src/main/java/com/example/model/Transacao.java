package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Transacao {
    //atributos;
    private Integer id;
    private String cliente;
    private double valor;
    private String moeda;
    private String tipo;

    public Transacao(String cliente, double valor, String moeda, String tipo) {
        this.cliente = cliente;
        this.valor = valor;
        this.moeda = moeda;
        this.tipo = tipo;
    }

    public List<Transacao> todasTransacoes = new ArrayList<>();

    //construtor;

    //metodos;
    public void adicionarTransacao(Transacao t){
        todasTransacoes.add(t);
    }

    public double getSaldo(String cliente){
        double saldo = 0.0;
        for (Transacao t : todasTransacoes) {
            if (t.cliente.equals(cliente)) {
                saldo += t.valor;
            }
        }
        return saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Transacao> getTodasTransacoes() {
        return todasTransacoes;
    }

    public void setTodasTransacoes(List<Transacao> todasTransacoes) {
        this.todasTransacoes = todasTransacoes;
    }

    @Override
    public String toString() {
        return "Transacao [id=" + id + ", cliente=" + cliente + ", valor=" + valor + ", moeda=" + moeda + ", tipo="
                + tipo + "]";
    }


}
