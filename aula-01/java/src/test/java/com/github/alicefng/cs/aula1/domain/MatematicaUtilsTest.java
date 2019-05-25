/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

import javax.accessibility.AccessibleAttributeSequence;

import java.util.*;

import com.github.alicefng.cs.aula1.domain.MatematicaUtils;

public class MatematicaUtilsTest {

    @Test
    public void testRestoDaDivisaoInteira() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.restoDaDivisaoInteira(0, 5));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.restoDaDivisaoInteira(100, -1));
        assertEquals(1, MatematicaUtils.restoDaDivisaoInteira(10, 3));
        assertEquals(0, MatematicaUtils.restoDaDivisaoInteira(100, 5));
    }

    @Test
    public void testProduto() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.produto(-10, 5));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.produto(100, -1));
        assertEquals(3000, MatematicaUtils.produto(10, 300));
    }

    @Test
    public void testPotencia() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.potencia(-10, 5));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.potencia(3, -1));
        assertEquals(100, MatematicaUtils.potencia(10, 2));
    }

    @Test
    public void testPossuiPropriedade3025() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.possuiPropriedade3025(10000));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.possuiPropriedade3025(-1));
        assertTrue(MatematicaUtils.possuiPropriedade3025(3025));
        assertFalse(MatematicaUtils.possuiPropriedade3025(3023));
    }

    @Test
    public void testPossuiPropriedade153() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.possuiPropriedade153(10000));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.possuiPropriedade153(-1));
        assertTrue(MatematicaUtils.possuiPropriedade153(153));
        assertFalse(MatematicaUtils.possuiPropriedade153(157));
    }

    @Test
    public void testSomaDosPrimeirosNaturais() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.somaDosPrimeirosNaturais(-1));
        assertEquals(55, MatematicaUtils.somaDosPrimeirosNaturais(10));
    }

    @Test
    public void testFatorial() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.fatorial(-1));
        assertEquals(120, MatematicaUtils.fatorial(5));
    }

    @Test
    public void testPi() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.pi(-1));
        assertEquals(4, MatematicaUtils.pi(1));
    }

    @Test
    public void testLogaritmoNatural() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.logaritmoNatural(-1, 10));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.logaritmoNatural(5, 1));
        assertEquals(2.5, MatematicaUtils.logaritmoNatural(1, 3));
    }

    @Test
    public void testRazaoAurea() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.razaoAurea(-1, 10, 10));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.razaoAurea(11, 10, 10));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.razaoAurea(7, 8, 0));
        assertEquals(1.5, MatematicaUtils.razaoAurea(1, 2, 1));
    }

    @Test
    public void testIsQuadradoPerfeito() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.isQuadradoPerfeito(0));
        assertTrue(MatematicaUtils.isQuadradoPerfeito(9));
        assertFalse(MatematicaUtils.isQuadradoPerfeito(7));
    }

    @Test
    public void testRaizQuadrada() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.raizQuadrada(0, 10));
        assertEquals(2, MatematicaUtils.raizQuadrada(4, 10));
    }

    @Test
    public void testIsPrimo() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.isPrimo(1));
        assertTrue(MatematicaUtils.isPrimo(7));
        assertFalse(MatematicaUtils.isPrimo(4));
    }

    @Test
    public void testMaiorDivisorComumMetodo1() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.maiorDivisorComumMetodo1(10, 100));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.maiorDivisorComumMetodo1(10, -1));
        assertEquals(5, MatematicaUtils.maiorDivisorComumMetodo1(10, 5));
    }

    @Test
    public void testMaiorDivisorComumMetodo2() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.maiorDivisorComumMetodo2(10, 100));
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.maiorDivisorComumMetodo2(10, -1));
        assertEquals(5, MatematicaUtils.maiorDivisorComumMetodo2(100, 5));
        assertEquals(1, MatematicaUtils.maiorDivisorComumMetodo2(10, 3));
    }

    @Test
    public void testCalcularPolinomio() {
        int[] vetorTest = {10, 5, 6};
        assertEquals(79, MatematicaUtils.calcularPolinomio(3, vetorTest));
    }

    @Test
    public void testObterEnesimoTermoDeFibonacci() {
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.obterEnesimoTermoDeFibonacci(-1));
        assertEquals(8, MatematicaUtils.obterEnesimoTermoDeFibonacci(6));
        assertEquals(0, MatematicaUtils.obterEnesimoTermoDeFibonacci(0));
        assertEquals(1, MatematicaUtils.obterEnesimoTermoDeFibonacci(1));
    }

    @Test
    public void testDeterminarNumerosPrimos() {
        int[] vetorTest1 = {1};
        int[] vetorTest2 = {0, 0, 0};
        int[] vetorTest2Compare = {0, 0, 0};
        int[] vetorTest3 = {0, 0, 0, 0, 0};
        int[] vetorTest3Compare = {1, 1, 1, 1, 1};
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.determinarNumerosPrimos(vetorTest1));
        assertFalse(vetorTest2Compare.equals
                (MatematicaUtils.determinarNumerosPrimos(vetorTest2)));

        vetorTest2[0] = 1;
        assertThrows(IllegalArgumentException.class,
                () -> MatematicaUtils.determinarNumerosPrimos(vetorTest2));

        assertFalse(vetorTest3Compare.equals
                (MatematicaUtils.determinarNumerosPrimos(vetorTest3)));
    }

    @Test
    public void testEstaDentroDoIntervalo() {
        assertTrue(MatematicaUtils.estaDentroDoIntervalo(10, -100, 100));
        assertFalse(MatematicaUtils.estaDentroDoIntervalo(-101, -100, 100));
    }

}