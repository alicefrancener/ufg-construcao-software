package com.github.alicefng.cs.aula10.domain;

/**
 * Classe para validar entrada do usuário pela linha de comando.
 */
public final class ValidaEntradaUtils {

    /**
     * Número de argumentos exigidos para ser utilizado em outros métodos.
     */
    private static final int NUMERO_ARGUMENTOS = 4;

    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private ValidaEntradaUtils() {

    }

    /**
     * Avalia se a quantidade de argumentos fornecidos é 4 (R7).
     *
     * @param argumentos Os argumentos fornecidos pelo usuário
     * @return -1, se o número de argumentos fornecidos não estiver de acordo
     * com o esperado; 0, se o número de argumentos estiver correto
     */
    public static int qtdArgumentos(final String[] argumentos) {
        return argumentos.length < NUMERO_ARGUMENTOS ? -1 : 0;
    }

    /**
     * Analisa se os argumentos são do tipo inteiro (R8).
     *
     * @param argumentos Os argumentos fornecidos pelo usuário.
     * @return -1, se algum dos argumentos não for inteiro; 0, se todos
     * argumentos forem inteiros
     */
    public static int argumentoIsInteiro(final String[] argumentos) {
        for (final String argumento : argumentos) {
            try {
                Integer.parseInt(argumento);
            } catch (NumberFormatException nfe) {
                return -1;
            }
        }
        return 0;
    }

}
