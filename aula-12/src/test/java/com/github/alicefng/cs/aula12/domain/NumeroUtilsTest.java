package com.github.alicefng.cs.aula12.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class NumeroUtilsTest {

    @Test
    public void testNumeroInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> NumeroUtils.getGrafiaNumeroCardinal(-10));
        assertThrows(IllegalArgumentException.class,
                () -> NumeroUtils.getGrafiaNumeroCardinal(10000));
    }

}