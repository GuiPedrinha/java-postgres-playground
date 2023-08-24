package com.example.model;

import java.util.List;
import java.util.NoSuchElementException;

public class CurrencyApi {
    private static List<Currency> currenyList = 
        List.of(
            new Currency("USD", "BRL", 4.80),
            new Currency("EUR", "BRL", 5.27),
            new Currency("BRL", "EUR", 0.18)
        );

    //metodo da API que devolve apenas a cotacao;
    //static pra nao precisar instaciar objeto, o obj ja é criado no proprio construtor;
    // percorre a lista e devolve a cotacao que o usuario quer from, to;
    //static so chama atributos staticos;

    public static double getQuote(String from, String to){
        for (Currency currency : currenyList) {
            if (currency.getFrom().equals(from) && currency.getTo().equals(to)){
                return currency.getQuote();
            }
        }

        throw new NoSuchElementException("nao foi possivel encontrar a cotacao.");

    }

    
        
}
