package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.IsJpegUtils;

import java.io.IOException;

/**
 * Para execução da classe IsJpegUtils.
 */
public final class Programa {

    /**
     * Construtor privado para evitar instanciação.
     */
    private Programa() {
    }

    /**
     * Programa para executar pelo terminal..
     *
     * @param args Caminho do arquivo a ser informado pelo usuário no terminal
     */
    public static void main(final String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Nenhum argumento foi " +
                    "fornecido.");
        }

        System.out.println(IsJpegUtils.isJpeg(args[0]));
    }

}
