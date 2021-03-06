/*
 * Copyright (c) 2019.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.alicefng.cs.aula1.domain;

/**
 * Implementação do algoritmo para calcular o  dia da semana de acordo com uma
 * data válida fornecida.
 */

public final class DataUtils {

    /**
     * Maior valor para um dia.
     */
    private static final int MAIOR_DIA = 31;

    /**
     * Menor valor para um dia.
     */
    private static final int MENOR_DIA = 1;

    /**
     * Inteiro correspondente ao primeiro mês do ano (janeiro).
     */
    private static final int JANEIRO = 1;

    /**
     * Inteiro correspondente ao segundo mês do ano (fevereiro).
     */
    private static final int FEVEREIRO = 2;

    /**
     * Inteiro correspondente ao último mês do ano (dezembro).
     */
    private static final int DEZEMBRO = 12;

    /**
     * Menor valor para um ano no algoritmo para calcular dia da semana.
     */
    private static final int MENOR_ANO = 1753;

    /**
     * Previne a classe utilitária de ser instanciada.
     */
    private DataUtils() {
    }

    /**
     * Valida dia.
     *
     * @param dia Inteiro que informa dia do mês
     * @throws DataInvalidaException Se o dia for inválido
     */
    public static void validaDia(final int dia) {
        if (dia < MENOR_DIA || dia > MAIOR_DIA) {
            throw new DataInvalidaException(String.format("dia: %d", dia),
                    new IllegalArgumentException());
        }
    }

    /**
     * Valida mês.
     *
     * @param mes Inteiro que informa mês do ano
     * @throws DataInvalidaException Se o mês for inválido
     */
    private static void validaMes(final int mes) {
        if (mes < JANEIRO || mes > DEZEMBRO) {
            throw new DataInvalidaException(String.format("mes: %d", mes),
                    new IllegalArgumentException());
        }
    }

    /**
     * Valida ano.
     *
     * @param ano Inteiro que informa ano
     * @throws DataInvalidaException Se o ano for inválido
     */
    private static void validaAno(final int ano) {
        if (ano <= MENOR_ANO) {
            throw new DataInvalidaException(String.format("ano: %d", ano),
                    new IllegalArgumentException());
        }
    }

    /**
     * Transforma inteiros (0 a 6) em strings correspondetes aos dias da semana.
     *
     * @param dia Inteiro que representa o dia da semana (0 = segunda,
     *            1 = terça, e assim sucessivamente)
     * @return String que representa o nome do dia da semana
     * @throws IllegalArgumentException se o dia informado estiver fora da
     *                                  amplitude
     */
    public static String diaDaSemanaToString(final int dia) {
        final int maximoDiasSemana = 6;
        if (dia < 0 || dia > maximoDiasSemana) {
            throw new IllegalArgumentException(String.format(
                    "dia inválido: %d. dia deve estar entre 0 e 6", dia));
        }

        final String[] nomesDiasDaSemana = {"segunda-feira", "terça-feira",
                "quarta-feira", "quinta-feira", "sexta-feira", "sábado",
                "domingo"};

        return nomesDiasDaSemana[dia];
    }

    /**
     * Calcula o dia da semana equivalente a data fornecida.
     *
     * @param dia Inteiro que informa dia do mês
     * @param mes Inteiro que informa mês do ano
     * @param ano Inteiro que informa ano
     * @return O nome do dia da semana correspondente a data fornecida
     * @throws DataInvalidaException Se algum dos argumentos for uma
     *                               data inválida
     */
    public static String diaDaSemana(final int dia, final int mes,
                                     final int ano)
            throws DataInvalidaException {
        validaDia(dia);
        validaMes(mes);
        validaAno(ano);

        final int totalMesesDeAno = 12;
        final int mesAux = mes == JANEIRO || mes == FEVEREIRO
                ? mes + totalMesesDeAno
                : mes;
        final int anoAux = mes == JANEIRO || mes == FEVEREIRO
                ? ano - 1
                : ano;

        final int diaDaSemana = dia + 2 * mesAux + 3 * (mesAux + 1) / 5 + anoAux
                + anoAux / 4 - anoAux / 100 + anoAux / 400;

        final int totalDiasDaSemana = 7;
        return diaDaSemanaToString(diaDaSemana % totalDiasDaSemana);
    }

}
