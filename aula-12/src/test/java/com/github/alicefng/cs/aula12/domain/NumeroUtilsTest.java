package com.github.alicefng.cs.aula12.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class NumeroUtilsTest {

    @Test
    public void testNumeroInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> NumeroUtils.getGrafiaNumeroCardinal(-10));
        assertThrows(IllegalArgumentException.class,
                () -> NumeroUtils.getGrafiaNumeroCardinal(10000));
    }

    @Test
    public void testGetMilhar() {
        assertEquals("mil", NumeroUtils.getGrafiaMillhar(1));
        assertEquals("três mil", NumeroUtils.getGrafiaMillhar(3));
        assertEquals("nove mil", NumeroUtils.getGrafiaMillhar(9));
    }

    @Test
    public void testGetCentena() {
        assertEquals("cento", NumeroUtils.getGrafiaCentena(1, 2, 0));
        assertEquals("cem", NumeroUtils.getGrafiaCentena(1, 0, 0));
        assertEquals("novecentos", NumeroUtils.getGrafiaCentena(9, 3, 1));
        assertEquals("oitocentos", NumeroUtils.getGrafiaCentena(8, 0, 0));
        assertEquals("cento", NumeroUtils.getGrafiaCentena(1, 0, 1));
    }

    @Test
    public void testGetDezena() {
        assertEquals("dez", NumeroUtils.getGrafiaDezena(1, 0));
        assertEquals("dezenove", NumeroUtils.getGrafiaDezena(1, 9));
        assertEquals("trinta", NumeroUtils.getGrafiaDezena(3, 9));
        assertEquals("noventa", NumeroUtils.getGrafiaDezena(9, 0));
    }

    @Test
    public void testGetUnidade() {
        assertEquals("zero", NumeroUtils.getGrafiaUnidade(0, 0, 0, 0));
        assertEquals("nove", NumeroUtils.getGrafiaUnidade(0, 0, 0, 9));
        assertEquals("dois", NumeroUtils.getGrafiaUnidade(9, 9, 9, 2));
        assertEquals(null, NumeroUtils.getGrafiaUnidade(9, 9, 9, 0));
        assertEquals(null, NumeroUtils.getGrafiaUnidade(9, 0, 9, 0));
        assertEquals(null, NumeroUtils.getGrafiaUnidade(0, 1, 9, 0));
        assertEquals(null, NumeroUtils.getGrafiaUnidade(3, 1, 0, 0));
        assertEquals(null, NumeroUtils.getGrafiaUnidade(0, 0, 8, 0));
    }

    @Test
    public void testGetGrafia() {
        String resultado = "dois mil";
        assertEquals(resultado, NumeroUtils.getGrafiaNumeroCardinal(2000));

        resultado = "treze";
        assertEquals(resultado, NumeroUtils.getGrafiaNumeroCardinal(13));

        resultado = "mil e trezentos";
        assertEquals(resultado, NumeroUtils.getGrafiaNumeroCardinal(1300));

        resultado = "quinhentos e trinta e cinco";
        assertEquals(resultado, NumeroUtils.getGrafiaNumeroCardinal(535));

        resultado = "cento e onze";
        assertEquals(resultado, NumeroUtils.getGrafiaNumeroCardinal(111));

        resultado = "nove mil, novecentos e noventa e nove";
        assertEquals(resultado, NumeroUtils.getGrafiaNumeroCardinal(9999));

    }
}