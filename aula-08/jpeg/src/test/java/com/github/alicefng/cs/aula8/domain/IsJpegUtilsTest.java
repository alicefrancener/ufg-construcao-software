package com.github.alicefng.cs.aula8.domain;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public final class IsJpegUtilsTest {

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
    public void testEhJpeg() throws IOException {
        assertTrue(IsJpegUtils.isJpeg(getFilename("imagem.jpeg")));
    }

    @Test
    public void testNaoEhJpeg() throws IOException {
        assertFalse(IsJpegUtils.isJpeg(getFilename("arquivo-com-frase.txt")));
        assertFalse(IsJpegUtils.isJpeg(getFilename(
                "package-info.class")));
    }

    @Test
    public void testExcecoes() throws IOException {
        assertThrows(IllegalArgumentException.class,
                () -> IsJpegUtils.isJpeg(getFilename("arquivo-vazio.txt")));
    }

}
