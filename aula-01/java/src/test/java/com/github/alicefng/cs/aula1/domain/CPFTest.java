/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

import org.junit.jupiter.api.Test;

import java.lang.String;

import static org.junit.jupiter.api.Assertions.*;

public class CPFTest {

    @Test
    public void cpfNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CPF.validarDigitosCPF(null));
        assertThrows(IllegalArgumentException.class,
                () -> CPF.validarDigitosCPF2(null));
    }

    @Test
    public void cpfMaiorQuePermitido() {
        assertThrows(IllegalArgumentException.class,
                () -> CPF.validarDigitosCPF("123456789012"));
        assertThrows(IllegalArgumentException.class,
                () -> CPF.validarDigitosCPF2("123456789012"));
    }

    @Test
    public void cpfMenorQuePermitido() {
        assertThrows(IllegalArgumentException.class,
                () -> CPF.validarDigitosCPF("1234567890"));
        assertThrows(IllegalArgumentException.class,
                () -> CPF.validarDigitosCPF2("1234567890"));
    }

    @Test
    public void cpfComOutrosCaracteres() {
        assertThrows(IllegalArgumentException.class,
                () -> CPF.validarDigitosCPF("a2345678901"));
        assertThrows(IllegalArgumentException.class,
                () -> CPF.validarDigitosCPF2("a2345678901"));
    }

    @Test
    public void cpfValido() {
        assertTrue(CPF.validarDigitosCPF("43415200086"));
        assertTrue(CPF.validarDigitosCPF2("43415200086"));
    }

    @Test
    public void cpfInvalido() {
        assertFalse(CPF.validarDigitosCPF("43415200016"));
        assertFalse(CPF.validarDigitosCPF2("43415200016"));
    }

    @Test
    public void coberturaCemPorCento() {
        assertNotNull(new CPF());
    }

}