package com.github.alicefng.cs.aula10.domain;

/**
 * Classe para validar entrada do usuário pela linha de comando.
 */
public final class ValidaEntradaUtils {

    private static final int NUMERO_ARGUMENTOS = 4;

    public static int qtdArgumentos(final String[] argumentos) {
        return argumentos.length < NUMERO_ARGUMENTOS ? -1 : 0;
    }
}
