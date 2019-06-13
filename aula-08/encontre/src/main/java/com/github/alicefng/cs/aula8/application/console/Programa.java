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
     * @param args Caminho do arquivo e palavra a ser procurada a ser informado
     *             pelo usuário no terminal
     */
    public static void main(final String[] args) throws IOException {
        if (args.length < 2) {
            if (args.length == 0) {
                throw new IllegalArgumentException("Nenhum argumento foi "
                        + "fornecido.");
            }
            throw new IllegalArgumentException("Um dos argumentos não foi "
                    + "fornecido.");
        }

        final String resultado =
                EncontraPalavraUtils.encontraPalavra(args[0], args[1]);
        System.out.println(resultado);
    }

}
