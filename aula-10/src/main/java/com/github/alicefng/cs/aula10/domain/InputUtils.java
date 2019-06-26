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
     * Avalia se a quantidade de argumentos fornecidos é 4.
     *
     * @param argumentos Os argumentos a serem avaliados
     * @throws IllegalArgumentException Se a quantidade de argumentos
     *                                  fornecida for diferente de 4.
     * @implNote Para atender o requisito R7
     */
    public static void evalQtdArgumentos(final String[] argumentos) {
        if (argumentos.length != NUMERO_ARGUMENTOS) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Avalia se os argumentos são números naturais (i.e., inteiros positivos).
     *
     * @param argumentos Os argumentos a serem avaliados
     * @throws IllegalArgumentException Se algum dos argumentos não for um
     *                                  número natural
     * @implNote Para atender o requisito R8 e R9
     */
    public static void evalArgumentoIsNatural(final String[] argumentos) {
        for (final String argumento : argumentos) {
            if (Integer.parseInt(argumento) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

}
