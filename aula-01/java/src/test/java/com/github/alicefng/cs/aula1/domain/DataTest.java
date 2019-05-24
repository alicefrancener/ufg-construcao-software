/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataTest {

    @Test
    public void diaInvalido() {
        assertThrows(DataInvalidaException.class,
                () -> Data.diaDaSemana(0, 1, 2019));
    }

    @Test
    public void diaInvalido2() {
        assertThrows(DataInvalidaException.class,
                () -> Data.diaDaSemana(32, 1, 2019));
    }

    @Test
    public void mesInvalido() {
        assertThrows(DataInvalidaException.class,
                () -> Data.diaDaSemana(1, 0, 2019));
    }

    @Test
    public void mesInvalido2() {
        assertThrows(DataInvalidaException.class,
                () -> Data.diaDaSemana(1, 13, 2019));
    }


    @Test
    public void anoMenorQueLimiteInferior() {
        assertThrows(DataInvalidaException.class,
                () -> Data.diaDaSemana(1, 13, 1750));
    }

    @Test
    public void nomesDiasDaSemana() {
        assertEquals("segunda-feira", Data.diaDaSemana(13, 5, 2019));
        assertEquals("terça-feira", Data.diaDaSemana(14, 5, 2019));
        assertEquals("quarta-feira", Data.diaDaSemana(15, 5, 2019));
        assertEquals("quinta-feira", Data.diaDaSemana(16, 5, 2019));
        assertEquals("sexta-feira", Data.diaDaSemana(17, 5, 2019));
        assertEquals("sábado", Data.diaDaSemana(18, 5, 2019));
        assertEquals("domingo", Data.diaDaSemana(19, 5, 2019));
    }

}