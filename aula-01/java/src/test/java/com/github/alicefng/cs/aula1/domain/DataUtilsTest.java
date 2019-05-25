/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.alicefng.cs.aula1.domain.DataUtils;

public class DataUtilsTest {

    @Test
    public void diaInvalido() {
        assertThrows(DataInvalidaException.class,
                () -> DataUtils.diaDaSemana(0, 1, 2019));
    }

    @Test
    public void diaInvalido2() {
        assertThrows(DataInvalidaException.class,
                () -> DataUtils.diaDaSemana(32, 1, 2019));
    }

    @Test
    public void mesInvalido() {
        assertThrows(DataInvalidaException.class,
                () -> DataUtils.diaDaSemana(1, 0, 2019));
    }

    @Test
    public void mesInvalido2() {
        assertThrows(DataInvalidaException.class,
                () -> DataUtils.diaDaSemana(1, 13, 2019));
    }


    @Test
    public void anoMenorQueLimiteInferior() {
        assertThrows(DataInvalidaException.class,
                () -> DataUtils.diaDaSemana(10, 5, 1700));
    }

    @Test
    public void nomesDiasDaSemana() {
        assertEquals("segunda-feira", DataUtils.diaDaSemana(13, 5, 2019));
        assertEquals("terça-feira", DataUtils.diaDaSemana(14, 5, 2019));
        assertEquals("quarta-feira", DataUtils.diaDaSemana(15, 5, 2019));
        assertEquals("quinta-feira", DataUtils.diaDaSemana(16, 5, 2019));
        assertEquals("sexta-feira", DataUtils.diaDaSemana(17, 5, 2019));
        assertEquals("sábado", DataUtils.diaDaSemana(19, 1, 2019));
        assertEquals("domingo", DataUtils.diaDaSemana(10, 2, 2019));
    }

    @Test
    public void diaDaSemanaToStringTest() {
        assertThrows(IllegalArgumentException.class,
                () -> DataUtils.diaDaSemanaToString(8));
        assertThrows(IllegalArgumentException.class,
                () -> DataUtils.diaDaSemanaToString(-1));
    }

    @Test
    public void testClasse() {
        assertThrows(UnsupportedOperationException.class, () -> new Data());
    }

}