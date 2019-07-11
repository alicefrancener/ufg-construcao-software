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
    public  void testGetMilhar() {
        assertEquals("mil", NumeroUtils.getGrafiaMillhar(1));
        assertEquals("três mil", NumeroUtils.getGrafiaMillhar(3));
        assertEquals("nove mil", NumeroUtils.getGrafiaMillhar(9));
    }

}