/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula7.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Locale;

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
        for (final double temperatura : temperaturas) {
            if (temperatura < menorTemperatura) {
                menorTemperatura = temperatura;
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
        return Arrays.stream(numeros).filter(n -> n % 2 != 0).sum();
    }

    /**
     * Produz a contagem em que determinado número ocorre em um vetor.
     *
     * @param numeros    Vetor contendo números a serem comparados
     * @param comparador Valor a ser comparado com vetor
     * @return Quantidade de vezes que o valor comparado ocorre no vetor
     */
    public static long conteIguais(final double[] numeros,
                                   final double comparador) {
        return Arrays.stream(numeros).filter(n -> n == comparador).count();
    }

    /**
     * Produz a quantidade de cada uma das letras do alfabeto em uma sequência
     * de caracteres (não distingue maiúsculas de minísculas).
     *
     * @param frase String contendo sequência de caracteres
     * @return Quantidade de cada uma das letras na String (sendo a posição 0
     * a letra a, a posição 1 a letra b, e assim sucessivamente)
     */
    public static int[] conteLetras(final String frase) {
        final String fraseMinuscula = frase.toLowerCase(Locale.getDefault());
        final int numeroLetrasAlfabeto = 26;
        int[] alfabeto = new int[numeroLetrasAlfabeto];

        for (int i = 0; i < fraseMinuscula.length(); i++) {
            final char caracter = fraseMinuscula.charAt(i);
            if (caracter >= 'a' && caracter <= 'z') {
                alfabeto[caracter - 'a']++;
            }
        }

        return alfabeto;
    }

    /**
     * Produz a quantidade de vezes que uma palavra ocorre em um vetor de
     * palavras.
     *
     * @param palavra A palavra a ser contada
     * @param frase   O vetor de palavras a ser comparado
     * @return Quantidade de vezes que a palavra ocorre
     */
    public static long contePalavra(final String palavra,
                                    final String[] frase) {
        return Arrays.stream(frase).filter(palavraEach ->
                palavraEach.equals(palavra)).count();
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
        long frequenciaPalavra = contePalavra(palavra, palavras);

        for (int i = 0; i < palavras.length; i++) {
            final long frequenciaProxPalavra = contePalavra(palavras[i],
                    palavras);
            if (frequenciaPalavra < frequenciaProxPalavra) {
                palavra = palavras[i];
                frequenciaPalavra = frequenciaProxPalavra;
            }
        }

        return palavra;
    }

    /**
     * Produz coleção contendo número mais sorteado e sua frequência. Se
     * houver mais de um número com a mesma frequência máxima, todos são
     * retornados.
     *
     * @return Coleção com número(s) mais sorteado e sua(s) frequência(s)
     */
    public static Map<Integer, Integer> numeroMaiSorteado() {
        final int qtdAleat = 1_000_000;
        final Random gerador = new Random();
        final Map<Integer, Integer> mapAleatorios = new HashMap<>();

        for (int i = 0; i < qtdAleat; i++) {
            final int numeroAleat = gerador.nextInt(1000);
            if (mapAleatorios.containsKey(numeroAleat)) {
                int freq = mapAleatorios.get(numeroAleat);
                freq++;
                mapAleatorios.put(numeroAleat, freq);
            } else {
                mapAleatorios.put(numeroAleat, 1);
            }
        }

        final int maxCount = getMaxFreq(mapAleatorios);

        return getMaxNumeroFreq(mapAleatorios, maxCount);
    }

    /**
     * Obtém a maior frequência de determinados números.
     *
     * @param mapNumerosFreq Números e suas determinadas frequências
     * @return A maior frequência encontrada
     */
    private static int getMaxFreq(final Map<Integer, Integer> mapNumerosFreq) {
        int maxFreq = 0;
        for (final Map.Entry<Integer, Integer> val
                : mapNumerosFreq.entrySet()) {
            if (maxFreq < val.getValue()) {
                maxFreq = val.getValue();
            }
        }

        return maxFreq;
    }

    /**
     * Produz coleção com inteiros que contêm determinada frequência.
     *
     * @param mapNumerosFreq Números e suas determinadas frequências
     * @param frequencia     Frequência desejeda dos números a serem obtidos
     * @return Map com números e suas determinadas ocorrências
     */
    private static Map<Integer, Integer> getMaxNumeroFreq(
            final Map<Integer, Integer> mapNumerosFreq, final int frequencia) {
        final Map<Integer, Integer> mapAleatoriosMaxFreq = new HashMap<>();
        for (final Map.Entry<Integer, Integer> val
                : mapNumerosFreq.entrySet()) {
            if (frequencia == val.getValue()) {
                mapAleatoriosMaxFreq.put(val.getKey(), frequencia);
            }
        }

        return mapAleatoriosMaxFreq;
    }

}
