package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Transacao {
    //atributos;
    private String cliente;
    private double valor;
    private String moeda;
    private String tipo;

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

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Transacao> getTodasTransacoes() {
        return todasTransacoes;
    }

    public void setTodasTransacoes(List<Transacao> todasTransacoes) {
        this.todasTransacoes = todasTransacoes;
    }

    @Override
    public String toString() {
        return "Transacao [cliente=" + cliente + ", valor=" + valor + ", moeda=" + moeda + ", tipo=" + tipo + "]";
    }

    



}
