package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    void testMdcP1Bimpar() {
        int a = 6;
        int b = 3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP1Bpar() {
        int a = 6;
        int b = 2;
        int esperado = 2;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    //esperado valor absoluto de uma variavel quando b = 0;
    void testMdcP3negativo() {
        int a = -6;
        int b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    //esperado valor absoluto de uma variavel quando b = 0;
    void testMdcP3positivo() {
        int a = 6;
        int b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    //esperado valor absoluto de uma variavel quando b = 0;
    void testMdcP5MaiorAntes() {
        int a = 6;
        int b = 2;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP5MaiorDepois() {
        int a = 2;
        int b = 6;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP7() {
        int a = 6;
        int b = 2;
        int esperado = MathUtil.mdc(-a, b);
        int obtido = MathUtil.mdc(-a, -b);

        assertEquals(esperado, obtido);
        System.out.println(esperado + ", " + obtido);
    }

}
