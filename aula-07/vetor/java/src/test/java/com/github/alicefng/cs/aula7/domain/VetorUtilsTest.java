/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula7.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VetorUtilsTest {

    @Test
    public void testMenorTemperatura() {
        double[] vetorTest1 = {15.8};
        double[] vetorTest2 = {30, 100.2, -55};

        assertEquals(15.8, VetorUtils.menorTemperatura(vetorTest1));
        assertEquals(-55, VetorUtils.menorTemperatura(vetorTest2));
    }
}
