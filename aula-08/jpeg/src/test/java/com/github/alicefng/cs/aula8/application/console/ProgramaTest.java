package com.github.alicefng.cs.aula8.application.console;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramaTest {

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
    public void testMain() throws IOException {
        String[] args = {getFilename("imagem.jpeg")};
        Programa.main(args);
    }

    @Test
    public void testMainExcecoes() throws IOException {
        String[] args = {getFilename("arquivo-vazio.txt")};
        assertThrows(IllegalArgumentException.class,
                () -> Programa.main(args));

        String[] args2 = {};
        assertThrows(IllegalArgumentException.class,
                () -> Programa.main(args2));
    }

}
