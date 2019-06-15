/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

import java.util.stream.IntStream;

/**
 * Implementação de algoritomos para validar CPF.
 */
public final class CpfUtils {

    /**
     * Valor correspondente ao tamanho (quantidade de dígitos) de um CPF.
     */
    private static final int TAMANHO_CPF = 11;

    /**
     * Índice correspondente ao 1º dígitos de um CPF em um vetor.
     */
    private static final int DIGITO_1 = 0;

    /**
     * Índice correspondente ao 2º dígitos de um CPF em um vetor.
     */
    private static final int DIGITO_2 = 1;

    /**
     * Índice correspondente ao 3º dígitos de um CPF em um vetor.
     */
    private static final int DIGITO_3 = 2;


    /**
     * Índice correspondente ao 8º dígitos de um CPF em um vetor.
     */
    private static final int DIGITO_8 = 7;

    /**
     * Índice correspondente ao 9º dígitos de um CPF em um vetor.
     */
    private static final int DIGITO_9 = 8;

    /**
     * Índice correspondente ao 10º dígitos de um CPF em um vetor.
     */
    private static final int DIGITO_10 = 9;

    /**
     * Índice correspondente ao 11º dígitos de um CPF em um vetor.
     */
    private static final int DIGITO_11 = 10;

    /**
     * Previne a classe utilitária de ser instanciada.
     */
    private CpfUtils() {
    }

    /**
     * Avalia se uma String contém apenas dígitos.
     *
     * @param cpf A string contendo o CPF a ser avaliado
     * @return verdadeiro, se a string contém apenos dígitos
     * falso, se a string contém outros caracteres
     */
    private static boolean sequenciaContemApenasDigitos(final String cpf) {
        return cpf.chars().allMatch(c -> Character.isDigit(c));
    }

    /**
     * Transforma caracteres numéricos em inteiros.
     *
     * @param cpf String que contém CPF
     * @return Vetor contendo em cada posição um dígito do CPF como inteiro
     */
    private static int[] converteCaracteresEmInteiros(final String cpf) {
        return cpf.chars().map(c -> Character.getNumericValue(c)).toArray();
    }

    /**
     * Avalia se CPF fornecido é válido dado seus dígitos verificadores
     * (dois últimos dígitos) - algoritmo 1.
     *
     * @param cpf String que contém CPF
     * @return verdadeiro, se dígitos verificadores do CPF estiverem corretos,
     * falso, se não
     */
    public static boolean validarDigitosCPF(final String cpf) {
        final int[] digitos = cpfStringParaDigitos(cpf);

        final int primeiro = primeiroDigitoVerificador(digitos);
        final int segundo = segundoDigitoVerificador(digitos);

        return confereDigitosVerificadores(digitos, primeiro, segundo);
    }

    /**
     * Produz o valor do segundo dígito verificador do CPF, com base no CPF.
     *
     * @param digitosCpf O número de CPF em um vetor
     * @return O valor calculado do primeiro dígito verificador
     */
    private static int primeiroDigitoVerificador(final int[] digitosCpf) {
        int calculoDigito10 = digitosCpf[DIGITO_1];
        for (int i = DIGITO_2; i < DIGITO_10; i++) {
            calculoDigito10 = calculoDigito10 + digitosCpf[i] * (i + 1);
        }

        final int numeroDigitos = 11;
        final int constante = 10;
        return (calculoDigito10 % numeroDigitos) % constante;
    }

    /**
     * Produz o valor do segundo dígito verificador do CPF, com base no CPF.
     *
     * @param digitosCpf O número de CPF em um vetor
     * @return O valor calculado do segundo dígito verificador
     */
    private static int segundoDigitoVerificador(final int[] digitosCpf) {
        final IntStream indices = IntStream.range(DIGITO_3, DIGITO_11);
        final int parcelas = (int) indices
                .mapToLong(i -> digitosCpf[i] * i).sum();

        final int numeroDigitos = 11;
        final int constante = 10;
        return ((parcelas + digitosCpf[DIGITO_2]) % numeroDigitos) % constante;
    }

    /**
     * Verifica se dígitos verificadores calculados, são iguais aos dígitos
     * do CPF.
     *
     * @param digitos  O número de CPF em um vetor
     * @param primeiro O primeiro dígito verificador
     * @param segundo  O segundo dígito verificador
     * @return True, se os dígitos verificadores forem iguais aos do CPF,
     * false, se algum deles não for igual
     */
    private static boolean confereDigitosVerificadores(
            final int[] digitos, final int primeiro, final long segundo) {
        return primeiro == digitos[DIGITO_10] & segundo == digitos[DIGITO_11];
    }

    /**
     * Avalia se CPF fornecido é válido dado seus dígitos verificadores
     * (dois últimos dígitos) - algoritmo 2.
     *
     * @param cpf String que contém CPF
     * @return verdadeiro, se dígitos verificadores do CPF estiverem corretos,
     * falso, se não
     */
    public static boolean validarDigitosCPF2(final String cpf) {
        final int[] digitosCpf = cpfStringParaDigitos(cpf);
        int calculoDigito11 = digitosCpf[DIGITO_9];
        int calculoDigito10 = digitosCpf[DIGITO_9];

        for (int i = DIGITO_8; i >= DIGITO_1; i--) {
            calculoDigito11 = calculoDigito11 + digitosCpf[i];
            calculoDigito10 = calculoDigito10 + calculoDigito11;
        }

        final int numeroDigitos = 11;
        final int constanteDez = 10;
        final int contanteNove = 9;
        calculoDigito10 = (calculoDigito10 % numeroDigitos) % constanteDez;
        calculoDigito11 = ((calculoDigito10 - calculoDigito11 + contanteNove
                * digitosCpf[DIGITO_10]) % numeroDigitos) % constanteDez;

        return calculoDigito10 == digitosCpf[DIGITO_10]
                & calculoDigito11 == digitosCpf[DIGITO_11];
    }

    /**
     * Produz o CPF que estava em um string para um vetor com dígitos inteiros.
     *
     * @param cpf String contendo o CPF
     * @return Os números de CPF em um vetor de inteiros
     * @throws IllegalArgumentException Se argumento é null
     * @throws IllegalArgumentException Se argumento não contém 11 dígitos
     * @throws IllegalArgumentException Se argumento contém algo diferente
     *                                  de dígitos
     */
    private static int[] cpfStringParaDigitos(final String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("cpf null");
        }
        if (cpf.length() != TAMANHO_CPF) {
            throw new IllegalArgumentException(String.format(
                    "cpf deve conter 11 dígitos: %s", cpf));
        }
        if (!sequenciaContemApenasDigitos(cpf)) {
            throw new IllegalArgumentException(String.format(
                    "cpf deve conter somente dígitos (0 a 9): %s", cpf));
        }

        return converteCaracteresEmInteiros(cpf);
    }

}
