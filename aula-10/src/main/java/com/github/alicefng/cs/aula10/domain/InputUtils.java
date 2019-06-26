package com.github.alicefng.cs.aula10.domain;

/**
 * Classe para validar entrada do usuário pela linha de comando.
 */
public final class InputUtils {

    /**
     * Número de argumentos exigidos para ser utilizado em outros métodos.
     */
    private static final int NUMERO_ARGUMENTOS = 4;

    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private InputUtils() {

    }

    /**
     * Avalia se a quantidade de argumentos fornecidos é 4 (R7).
     *
     * @param argumentos Os argumentos fornecidos pelo usuário
     * @return -1, se o número de argumentos fornecidos não estiver de acordo
     * com o esperado; 0, se o número de argumentos estiver correto
     */
    public static void qtdArgumentos(final String[] argumentos) {
        if (argumentos.length != NUMERO_ARGUMENTOS){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Analisa se os argumentos são do números naturais(R8 e R9). Obs: números
     * naturais são os inteiros positivos.
     *
     * @param argumentos Os argumentos fornecidos pelo usuário.
     * @return -1, se algum dos argumentos não for natural; 0, se todos
     * argumentos forem naturais
     */
    public static void argumentoIsNatural(final String[] argumentos) {
        for (final String argumento : argumentos) {
            if (Integer.parseInt(argumento) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

}
