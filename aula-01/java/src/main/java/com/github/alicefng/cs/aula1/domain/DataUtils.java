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
    public static final int MAIOR_DIA = 31;

    /**
     * Menor valor para um dia.
     */
    public static final int MENOR_DIA = 1;

    /**
     * Maior valor para um mês.
     */
    public static final int MAIOR_MES = 12;

    /**
     * Menor valor para um mês.
     */
    public static final int MENOR_MES = 1;

    /**
     * Menor valor para um ano no algoritmo para calcular dia da semana.
     */
    public static final int MENOR_ANO = 1753;


    /**
     * Previne a classe utilitária de ser instanciada.
     */
    private DataUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Valida dia.
     *
     * @param dia Inteiro que informa dia do mês
     * @throws DataInvalidaException Se o dia for inválido
     */
    public static void validaDia(final int dia) {
        if (dia < MENOR_DIA || dia > MAIOR_DIA) {
            throw new DataInvalidaException("dia invalido: " + dia);
        }
    }

    /**
     * Valida mês.
     *
     * @param mes Inteiro que informa mês do ano
     * @throws DataInvalidaException Se o mês for inválido
     */
    private static void validaMes(final int mes) {
        if (mes < MENOR_MES || mes > MAIOR_MES) {
            throw new DataInvalidaException("mes inválido: " + mes);
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
            throw new DataInvalidaException("ano inválido: " + ano);
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
            throw new IllegalArgumentException("Dia inválido: " + dia + ". "
                    + "Dia deve estar entre 0 e 6.");
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
     */
    public static String diaDaSemana(final int dia, final int mes,
                                     final int ano) {
        validaDia(dia);
        validaMes(mes);
        validaAno(ano);

        final int totalMesesDeAno = 12;
        final int mesAux = ((mes == 1) || (mes == 2))
                ? (mes + totalMesesDeAno)
                : mes;
        final int anoAux = mes == 1 || mes == 2
                ? ano - 1
                : ano;

        final int diaDaSemana = dia + 2 * mesAux + 3 * (mesAux + 1) / 5 + anoAux
                + anoAux / 4 - anoAux / 100 + anoAux / 400;

        final int totalDiasDaSemana = 7;
        return diaDaSemanaToString(diaDaSemana % totalDiasDaSemana);
    }

}
