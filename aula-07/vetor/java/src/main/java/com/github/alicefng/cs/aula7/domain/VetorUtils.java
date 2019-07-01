/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula7.domain;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Implementação de várias operações com vetores.
 */
public final class VetorUtils {

    /**
     * Previne a classe utilitária de ser instanciada.
     */
    private VetorUtils() {
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
        final int soma = Arrays.stream(numeros).filter(n -> n % 2 == 1).sum();
        return soma;
    }

    /**
     * Produz a contagem em que determinado número ocorre em um vetor.
     *
     * @param numeros    Vetor contendo números a serem comparados
     * @param comparador Valor a ser comparado com vetor
     * @return Quantidade de vezes que o valor comparado ocorre no vetor
     */
    public static int conteIguais(final double[] numeros,
                                  final double comparador) {
        int quantidade = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == comparador) {
                quantidade++;
            }
        }

        return quantidade;
    }

    /**
     * Produz a quantidade de letras em uma sequência de caracteres.
     *
     * @param sequenciaCaracteres String contendo sequência de caracteres
     * @return Quantidade de caracteres que são letras
     */
    public static int conteLetras(final String sequenciaCaracteres) {
        int quantidadeLetras = 0;
        for (int i = 0; i < sequenciaCaracteres.length(); i++) {
            if (Character.isLetter(sequenciaCaracteres.charAt(i))) {
                quantidadeLetras++;
            }
        }

        return quantidadeLetras;
    }

    /**
     * Produz a quantidade de vezes que uma palavra ocorre em um vetor de
     * palavras.
     *
     * @param palavra A palavra a ser contada
     * @param frase   O vetor de palavras a ser comparado
     * @return Quantidade de vezes que a palavra ocorre
     */
    public static int contePalavra(final String palavra,
                                   final String[] frase) {

        int quantidade = 0;
        for (int i = 0; i < frase.length; i++) {
            if (palavra.equals(frase[i])) {
                quantidade++;
            }
        }

        return quantidade;
    }

    /**
     * Retorna a palavra mais frequence em uma determinada sequêcia de
     * caracteres.
     *
     * @param frase Frase a ser analisada
     * @return Palavra que ocorre com mais frequência na frase analisada.
     */
    public static String palavraMaisFrequente(final String frase) {
        final String[] palavras = frase.split(" ");

        String palavra = palavras[0];
        int frequenciaPalavra = contePalavra(palavra, palavras);

        for (int i = 0; i < palavras.length; i++) {
            int frequenciaProxPalavra = contePalavra(palavras[i], palavras);
            if (frequenciaPalavra < frequenciaProxPalavra) {
                palavra = palavras[i];
                frequenciaPalavra = frequenciaProxPalavra;
            }
        }

        return palavra;
    }

}
