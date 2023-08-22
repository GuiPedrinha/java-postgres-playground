package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AlunoTest {
    @Test
    void testCalculaMedia() {
        //instaciar obj a ser testado;
        var aluno = new Aluno();
        aluno.setNota1(10);
        aluno.setNota2(8);
        aluno.setNota3(8);
        var esperado = 8.66;
        var obtido = aluno.calculaMedia();

        // o terceiro parametro é o DELTA de erro aceito para casa decimais;
        assertEquals(esperado, obtido, 0.1);

    }
}
