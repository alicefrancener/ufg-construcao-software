package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.EncontraPalavraUtils;

import java.io.IOException;

/**
 * Classe para executar o EncontraPalavraUtils pelo temrinal.
 */
public final class Programa {

    /**
     * Construtor privado para evitar instanciação.
     */
    private Programa() {
    }

    /**
     * Executor.
     *
     * @param args Argumentos a ser inseridos pelo usuário no terminal
     */
    public static void main(final String[] args) throws IOException {
        final String resultado =
                EncontraPalavraUtils.encontraPalavra(args[0], args[1]);
        System.out.println(resultado);

    }

}
