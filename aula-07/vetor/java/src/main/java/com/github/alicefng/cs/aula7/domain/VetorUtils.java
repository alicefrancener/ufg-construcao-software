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
     *
     * @param temperaturas Vetor contendo valores de temperaturas
     * @return A menor temperatura registrada no vetor
     */
    public static double menorTemperatura(final double[] temperaturas) {

        double menorTemperatura = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++) {
            if (menorTemperatura > temperaturas[i]) {
                menorTemperatura = temperaturas[i];
            }
        }
        return menorTemperatura;
    }

    /**
     * Produz a soma dos números ímpares de um vetor.
     *
     * @param numeros Vetor contendo inteiros
     * @return A soma dos ímpares do vetor
     */
    public static int somaImpares(final int[] numeros) {
        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 1) {
                soma = soma + numeros[i];
            }
        }

        return soma;
    }

    /**
     * Produz a contagem em que determinado número ocorre em um vetor.
     * @param numeros
     * @param comparador
     * @return
     */
    public static int conteIguais(final double[] numeros,
                                  final double comparador) {
        int quantidade = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == comparador) {
                quantidade = quantidade + 1;
            }
        }

        return quantidade;
    }
}
