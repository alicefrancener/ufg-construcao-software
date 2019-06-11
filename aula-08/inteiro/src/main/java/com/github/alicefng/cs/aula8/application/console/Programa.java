package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.OutputArquivo;

import java.io.IOException;

public class Programa {

    /**
     * Programa para executar pelo terminal.
     *
     * @param args Argumentos a ser inseridos pelo usuário no terminal
     */
    public static void main(final String[] args) {
        try {
            OutputArquivo.imprimeHexadecimal(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
