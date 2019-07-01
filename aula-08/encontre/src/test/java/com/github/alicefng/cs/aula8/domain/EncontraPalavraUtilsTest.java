package com.github.alicefng.cs.aula8.domain;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class EncontraPalavraUtilsTest {

    /* Método getFilename() copiado de:
     * https://github.com/ottoleggio/cs-2019-01/tree/master/aula-08/inteiro
     * /src/test/java/com/github/ottoleggio/cs/aula8/application/console
     * /ProgramaInteiroTest.java
     */
    private String getFilename(String string) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(string).getFile());


        String absolutePath = file.getAbsolutePath();

        return absolutePath;
    }

    @Test
    public void testConteOcorrencias() {
        assertEquals(2, EncontraPalavraUtils.conteOcorrencias("teste",
                "o teste é necessário, sempre mais um teste"));
        assertEquals(0, EncontraPalavraUtils.conteOcorrencias("teste",
                "nesse texto essa palavra não existe"));
    }

    @Test
    public void testEncontraPalavra() {
        String stringEsperada = String.format("Encontradas: 3%n"
                + "L1 C6: It is never too late to be what you might have been. "
                + "George Eliot%n"
                + "L3 C1:  never never%n");

        assertEquals(stringEsperada, EncontraPalavraUtils.encontraPalavra(
                getFilename("arquivo-com-frase.txt"), "never"));

        String stringEsperada2 = String.format("Encontradas: 0%n");
        assertEquals(stringEsperada2, EncontraPalavraUtils.encontraPalavra(
                getFilename("arquivo-com-frase.txt"), "oi"));
    }

    @Test
    public void testExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> EncontraPalavraUtils.encontraPalavra(getFilename(
                        "arquivo-vazio.txt"), "palavra"));
    }

}
