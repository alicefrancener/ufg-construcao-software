package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.EncontraPalavra;

import java.io.IOException;

/**
 * Classe para executar o EncontraPalavra pelo temrinal.
 */
public class Programa {

    /**
     * Executor.
     *
     * @param args Argumentos a ser inseridos pelo usuário no terminal
     */
    public static void main(final String[] args) {
        try {
            String resultado =
                    EncontraPalavra.encontraPalavra(args[0], args[1]);
            System.out.println(resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
