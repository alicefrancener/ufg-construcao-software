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

import com.github.alicefng.cs.aula1.domain.Matematica;

public class MatematicaTest {

    @Test
    public void testRestoDaDivisaoInteira() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.restoDaDivisaoInteira(0, 5));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.restoDaDivisaoInteira(100, -1));
        assertEquals(1, Matematica.restoDaDivisaoInteira(10, 3));
        assertEquals(0, Matematica.restoDaDivisaoInteira(100, 5));
    }

    @Test
    public void testProduto() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.produto(-10, 5));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.produto(100, -1));
        assertEquals(3000, Matematica.produto(10, 300));
    }

    @Test
    public void testPotencia() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.potencia(-10, 5));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.potencia(3, -1));
        assertEquals(100, Matematica.potencia(10, 2));
    }

    @Test
    public void testPossuiPropriedade3025() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.possuiPropriedade3025(10000));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.possuiPropriedade3025(-1));
        assertTrue(Matematica.possuiPropriedade3025(3025));
        assertFalse(Matematica.possuiPropriedade3025(3023));
    }

    @Test
    public void testPossuiPropriedade153() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.possuiPropriedade153(10000));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.possuiPropriedade153(-1));
        assertTrue(Matematica.possuiPropriedade153(153));
        assertFalse(Matematica.possuiPropriedade153(157));
    }

    @Test
    public void testSomaDosPrimeirosNaturais() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.somaDosPrimeirosNaturais(-1));
        assertEquals(55, Matematica.somaDosPrimeirosNaturais(10));
    }

    @Test
    public void testFatorial() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.fatorial(-1));
        assertEquals(120, Matematica.fatorial(5));
    }

    @Test
    public void testPi() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.pi(-1));
        assertEquals(4, Matematica.pi(1));
    }

    @Test
    public void testLogaritmoNatural() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.logaritmoNatural(-1, 10));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.logaritmoNatural(5, 1));
        assertEquals(2.5, Matematica.logaritmoNatural(1, 3));
    }

    @Test
    public void testRazaoAurea() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.razaoAurea(-1, 10, 10));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.razaoAurea(11, 10, 10));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.razaoAurea(7, 8, 0));
        assertEquals(1.5, Matematica.razaoAurea(1, 2, 1));
    }

    @Test
    public void testIsQuadradoPerfeito() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.isQuadradoPerfeito(0));
        assertTrue(Matematica.isQuadradoPerfeito(9));
        assertFalse(Matematica.isQuadradoPerfeito(7));
    }

    @Test
    public void testRaizQuadrada() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.raizQuadrada(0, 10));
        assertEquals(2, Matematica.raizQuadrada(4, 10));
    }

    @Test
    public void testIsPrimo() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.isPrimo(1));
        assertTrue(Matematica.isPrimo(7));
        assertFalse(Matematica.isPrimo(4));
    }

    @Test
    public void testMaiorDivisorComumMetodo1() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.maiorDivisorComumMetodo1(10, 100));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.maiorDivisorComumMetodo1(10, -1));
        assertEquals(5, Matematica.maiorDivisorComumMetodo1(10, 5));
    }

    @Test
    public void testMaiorDivisorComumMetodo2() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.maiorDivisorComumMetodo2(10, 100));
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.maiorDivisorComumMetodo2(10, -1));
        assertEquals(5, Matematica.maiorDivisorComumMetodo2(100, 5));
        assertEquals(1, Matematica.maiorDivisorComumMetodo2(10, 3));
    }

    @Test
    public void testCalcularPolinomio() {
        int[] vetorTest = {10, 5, 6};
        assertEquals(79, Matematica.calcularPolinomio(3, vetorTest));
    }

    @Test
    public void testObterEnesimoTermoDeFibonacci() {
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.obterEnesimoTermoDeFibonacci(-1));
        assertEquals(8, Matematica.obterEnesimoTermoDeFibonacci(6));
        assertEquals(0, Matematica.obterEnesimoTermoDeFibonacci(0));
        assertEquals(1, Matematica.obterEnesimoTermoDeFibonacci(1));
    }

    @Test
    public void testDeterminarNumerosPrimos() {
        int[] vetorTest1 = {1};
        int[] vetorTest2 = {0, 0, 0};
        int[] vetorTest2Compare = {0, 0, 0};
        int[] vetorTest3 = {0, 0, 0, 0, 0};
        int[] vetorTest3Compare = {1, 1, 1, 1, 1};
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.determinarNumerosPrimos(vetorTest1));
        assertFalse(vetorTest2Compare.equals
                (Matematica.determinarNumerosPrimos(vetorTest2)));

        vetorTest2[0] = 1;
        assertThrows(IllegalArgumentException.class,
                () -> Matematica.determinarNumerosPrimos(vetorTest2));

        assertFalse(vetorTest3Compare.equals
                (Matematica.determinarNumerosPrimos(vetorTest3)));
    }

    @Test
    public void testEstaDentroDoIntervalo() {
        assertTrue(Matematica.estaDentroDoIntervalo(10, -100, 100));
        assertFalse(Matematica.estaDentroDoIntervalo(-101, -100, 100));
    }

    @Test
    public void testClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new Matematica());
    }
}