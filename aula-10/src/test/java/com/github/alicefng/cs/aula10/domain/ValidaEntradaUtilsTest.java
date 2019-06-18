package com.github.alicefng.cs.aula10.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidaEntradaUtilsTest {

    @Test
    public void testQtdArgumentos() {
        String[] test1 = {};
        assertEquals(-1, ValidaEntradaUtils.qtdArgumentos(test1));

        String[] test2 = {"1", "2"};
        assertEquals(-1, ValidaEntradaUtils.qtdArgumentos(test2));

        String[] test3 = {"1", "2", "3", "4"};
        assertEquals(0, ValidaEntradaUtils.qtdArgumentos(test3));
    }

    @Test
    public void testIsInteiro() {
        String[] test1 = {"20190618", "2011", "20190618", "1"};
        assertEquals(0, ValidaEntradaUtils.argumentoIsNatural(test1));

        String[] test2 = {"alice", "2011", "20190618", "1"};
        assertEquals(-1, ValidaEntradaUtils.argumentoIsNatural(test2));

        String[] test3 = {"20190618", "10.5", "20190618", "1"};
        assertEquals(-1, ValidaEntradaUtils.argumentoIsNatural(test3));
    }

    @Test
    public void testIsPositivo() {
        String[] test1 = {"-20190618", "2011", "20190618", "1"};
        assertEquals(-1, ValidaEntradaUtils.argumentoIsNatural(test1));

        String[] test2 = {"20190618", "2011", "20190618", "-1"};
        assertEquals(-1, ValidaEntradaUtils.argumentoIsNatural(test2));

        String[] test3 = {"20190618", "10", "20190618", "1"};
        assertEquals(0, ValidaEntradaUtils.argumentoIsNatural(test3));
    }

}
