package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.OutputArquivoUtils;

import java.io.IOException;

/**
 * Para execuçlão da classe OutputArquivoUtils.
 */
public final class Programa {

    /**
     * Construtor privado para evitar instanciação.
     */
    private Programa() {
    }

    /**
     * Programa para executar pelo terminal.
     *
     * @param args Argumentos a ser inseridos pelo usuário no terminal
     */
    public static void main(final String[] args) {
        try {
            OutputArquivoUtils.imprimeHexadecimal(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
