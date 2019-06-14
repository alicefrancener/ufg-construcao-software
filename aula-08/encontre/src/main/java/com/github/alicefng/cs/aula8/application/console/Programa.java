package com.github.alicefng.cs.aula8.application.console;

import com.github.alicefng.cs.aula8.domain.EncontraPalavraUtils;

import java.io.IOException;

/**
 * Classe para executar o EncontraPalavraUtils pelo terminal.
 */
public final class Programa {

    /**
     * O número de parâmetros necessários para executar o método.
     */
    private static final int NUMERO_PARAMETROS = 2;

    /**
     * Construtor privado para evitar instanciação.
     */
    private Programa() {
    }

    /**
     * Programa para executar pelo terminal e fazer um relatório de quantas
     * vezes uma  palavra ocorre em determinado arquivo e em quais locais.
     *
     * @param args Caminho do arquivo e palavra a ser procurada a ser informado
     *             pelo usuário no terminal
     * @throws IOException              se houver problema na leitura do caminho
     *                                  do arquivo
     * @throws IllegalArgumentException se não for passado nenhum argumento
     *                                  pela linha de comando, ou se for
     *                                  passando somente um dos argumentos
     */
    public static void main(final String[] args) throws IOException {
        if (args.length < NUMERO_PARAMETROS) {
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
