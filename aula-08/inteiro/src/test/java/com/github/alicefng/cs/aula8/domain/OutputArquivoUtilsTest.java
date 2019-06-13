package com.github.alicefng.cs.aula8.domain;

import com.github.alicefng.cs.aula8.application.console.Programa;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public final class OutputArquivoUtilsTest {

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
    public void testimprimeHexadecimal() throws IOException {
        assertEquals("49742069", OutputArquivoUtils.imprimeHexadecimal(
                getFilename("arquivo-com-frase.txt")));
    }

    @Test
    public void testimprimeHexadecimalClass() throws IOException {
        assertEquals("cafebabe", OutputArquivoUtils.imprimeHexadecimal
                (getFilename("package-info.class")));
    }

    @Test
    public void testExcecoesArquivo() throws IOException {
        assertThrows(IllegalArgumentException.class,
                () -> OutputArquivoUtils.imprimeHexadecimal
                        (getFilename("arquivo-tamanho-minimo.txt")));

        assertThrows(IllegalArgumentException.class,
                () -> OutputArquivoUtils.imprimeHexadecimal
                        (getFilename("arquivo-vazio.txt")));
    }

    @Test
    public void testMain() throws IOException {
        String[] args = {getFilename("package-info.class")};
        Programa.main(args);
    }

    @Test
    public void testMainExcecoes() throws IOException {
        String[] args = {getFilename("arquivo-vazio.txt")};
        assertThrows(IllegalArgumentException.class,
                () -> Programa.main(args));
    }

}
