package com.example.model;

public class ConversorMoeda {
    //atributos;
    private double cambioRealDolar;
    private double cambioRealEuro;
   

    //construtor;
    public ConversorMoeda() {
        var apiTaxaDeCambio =  new APITaxaDeCambio();
        this.cambioRealDolar = apiTaxaDeCambio.getCambioDolarReal();
        this.cambioRealEuro = apiTaxaDeCambio.getCambioEuroReal();
    }

    //metodos;
    public double cambioReal(double valorBRL, String moedaCambio) {
        
        double valorConvertido = 0;

        if (moedaCambio.equalsIgnoreCase("USD")) {
            valorConvertido = valorBRL * cambioRealDolar;
        } 
        else valorConvertido = valorBRL * cambioRealEuro;

        System.out.println("Moeda convertida com sucesso.");

        return valorConvertido;
    }

}
