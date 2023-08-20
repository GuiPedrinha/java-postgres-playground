package com.example;


public class MathUtil {
    
    static public int mdc(int a, int b){
        // atribui a valores absolutos, n importa o sinal que for passado;
        a = Math.abs(a);
        b = Math.abs(b);
        //ordenando maior e menor pra ser comutativo;
        // nao alterar o A antes!; fazer enessa ordem;
        int maior = Math.max(a, b);
        b = Math.min(a, b);
        a = Math.max(maior, b);

        if ( b > 0 && a % b == 0 )
            return b;

        if( b == 0)
            return Math.abs(a);
        
        // falha proposital;
        throw new UnsupportedOperationException("Nao foi possivel calcular o MDC.");
    }

}
