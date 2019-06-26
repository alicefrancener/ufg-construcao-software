package com.github.alicefng.cs.aula10.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputUtilsTest {

    @Test
    public void testQtdArgumentos() {
        String[] test1 = {};
        assertThrows(IllegalArgumentException.class,
                () -> InputUtils.qtdArgumentos(test1));

        String[] test2 = {"1", "2"};
        assertThrows(IllegalArgumentException.class,
                () -> InputUtils.qtdArgumentos(test2));

        String[] test3 = {"1", "2", "3"};
        assertThrows(IllegalArgumentException.class,
                () -> InputUtils.qtdArgumentos(test3));
    }

    @Test
    public void testIsInteiro() {
        String[] test1 = {"20190618", "10.5", "20190618", "1"};
        assertThrows(NumberFormatException.class,
                () -> InputUtils.argumentoIsNatural(test1));

        String[] test2 = {"alice", "2011", "20190618", "1"};
        assertThrows(NumberFormatException.class,
                () -> InputUtils.argumentoIsNatural(test2));
    }

    @Test
    public void testIsNumeroPositivo() {
        String[] test1 = {"-20190618", "2011", "20190618", "1"};
        assertThrows(IllegalArgumentException.class,
                () -> InputUtils.argumentoIsNatural(test1));

        String[] test2 = {"20190618", "2011", "20190618", "-1"};
        assertThrows(IllegalArgumentException.class,
                () -> InputUtils.argumentoIsNatural(test2));
    }

}
