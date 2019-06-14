package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.OutputArquivoUtils;

import java.io.IOException;

/**
 * Para execução da classe OutputArquivoUtils.
 */
public final class Programa {

    /**
     * Construtor privado para evitar instanciação.
     */
    private Programa() {
    }

    /**
     * Programa para executar pelo terminal e mostrar primeiros 4 bytes de um
     * arquivo.
     *
     * @param args Caminho do arquivo a ser informado pelo usuário no terminal
     * @throws IOException              se houver problema na leitura do caminho
     *                                  do arquivo
     * @throws IllegalArgumentException se não for passado nenhum argumento
     *                                  pela linha de comando
     */
    public static void main(final String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Nenhum argumento foi "
                    + "fornecido.");
        }

        System.out.println(OutputArquivoUtils.imprimeHexadecimal(args[0]));
    }

}
