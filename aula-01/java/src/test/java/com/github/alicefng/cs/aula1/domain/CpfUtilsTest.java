/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

import org.junit.jupiter.api.Test;

import java.lang.String;

import static org.junit.jupiter.api.Assertions.*;

import com.github.alicefng.cs.aula1.domain.CpfUtils;

public class CpfUtilsTest {

    @Test
    public void cpfNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CpfUtils.validarDigitosCPF(null));
        assertThrows(IllegalArgumentException.class,
                () -> CpfUtils.validarDigitosCPF2(null));
    }

    @Test
    public void cpfMaiorQuePermitido() {
        assertThrows(IllegalArgumentException.class,
                () -> CpfUtils.validarDigitosCPF("123456789012"));
        assertThrows(IllegalArgumentException.class,
                () -> CpfUtils.validarDigitosCPF2("123456789012"));
    }

    @Test
    public void cpfMenorQuePermitido() {
        assertThrows(IllegalArgumentException.class,
                () -> CpfUtils.validarDigitosCPF("1234567890"));
        assertThrows(IllegalArgumentException.class,
                () -> CpfUtils.validarDigitosCPF2("1234567890"));
    }

    @Test
    public void cpfComOutrosCaracteres() {
        assertThrows(IllegalArgumentException.class,
                () -> CpfUtils.validarDigitosCPF("a2345678901"));
        assertThrows(IllegalArgumentException.class,
                () -> CpfUtils.validarDigitosCPF2("a2345678901"));
    }

    @Test
    public void cpfValido() {
        assertTrue(CpfUtils.validarDigitosCPF("43415200086"));
        assertTrue(CpfUtils.validarDigitosCPF2("43415200086"));
    }

    @Test
    public void cpfInvalido() {
        assertFalse(CpfUtils.validarDigitosCPF("43415200016"));
        assertFalse(CpfUtils.validarDigitosCPF2("43415200016"));
    }

}