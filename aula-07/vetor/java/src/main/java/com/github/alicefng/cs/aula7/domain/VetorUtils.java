/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula7.domain;

/**
 * Implementação de várias operações com vetores.
 */
public final class VetorUtils {

    /**
     * Previne a classe utilitária de ser instanciada.
     */
    private VetorUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Encontra a menor temperatura em um vetor de valores.
     * @param temperaturas Vetor contendo valores de temperaturas
     * @return A menor temperatura registrada no vetor
     */
    public static double menorTemperatura(final double[] temperaturas) {

        double menorTemperatura = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++){
            if (menorTemperatura > temperaturas[i]) {
                menorTemperatura = temperaturas[i];
            }
        }
        return menorTemperatura;
    }

}
