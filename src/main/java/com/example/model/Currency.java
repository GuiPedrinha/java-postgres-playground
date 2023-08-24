package com.example.model;


public class Currency {
    //atributos;
    private String from;
    private String to;
    private double quote;
    
    //construtor;
    public Currency(String from, String to, double quote) {
        this.from = from;
        this.to = to;
        this.quote = quote;
    }

        public double getQuote() {
        return quote;
    }

        public String getFrom() {
            return from;
        }
    
        public String getTo() {
            return to;
        }

}
