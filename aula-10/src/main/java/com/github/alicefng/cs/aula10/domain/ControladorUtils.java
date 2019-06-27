package com.github.alicefng.cs.aula10.domain;

/**
 * Classe para avaliar parâmetros com uso das classes InputEvalUtils e
 * CalendarEvalUtils, além de executar o programa para obter o dia da semana
 * de interesse com uso da classe CalendarUtils.
 */
public final class ControladorUtils {

    /**
     * Índice da data de interesse no parâmetro String[] fornecido.
     */
    private static final int INDEX_DATA_INTERESSE = 0;

    /**
     * Índice do ano bissexto de referência no parâmetro String[] fornecido.
     */
    private static final int INDEX_ANO_BISSEXTO = 1;

    /**
     * Índice da data de referência no parâmetro String[] fornecido.
     */
    private static final int INDEX_DATA_REFERENCIA = 2;

    /**
     * Índice do dia da semana da data de referência no parâmetro String[]
     * fornecido.
     */
    private static final int INDEX_DIA_DA_SEMANA = 3;


    /**
     * Construtor privado para evitar instaciação da classe utilitária.
     */
    private ControladorUtils() {

    }

    /**
     * Executa método para obter dia da semana, avaliando todos os parâmetros
     * de  entrada fornecidos.
     *
     * @param argumentos Argumentos a serem fornecidos pelo usuário
     * @return -1, caso os argumentos fornecidos não estejam de acordo com
     * especificado pelos requisitos; return 0 a 6, caso os parâmetros estejam
     * corretos, sendo 0 correspondente à segunda-feira, 1, terça-feira, e
     * assim sucessivamente.
     * @implNote Para atender aos requisitos de entrada (R1 a R5) e de
     * saída (R6 a R14)
     */
    public static int executar(final String[] argumentos) {
        try {
            InputEvalUtils.evalQtdArgumentos(argumentos);
            InputEvalUtils.evalArgumentoIsNatural(argumentos);

            CalendarEvalUtils.evalAnoBissexto(argumentos[INDEX_ANO_BISSEXTO]);
            CalendarEvalUtils.evalDiaDaSemana(argumentos[INDEX_DIA_DA_SEMANA]);

            CalendarEvalUtils.evalData(argumentos[INDEX_DATA_INTERESSE],
                    argumentos[INDEX_ANO_BISSEXTO]);
            CalendarEvalUtils.evalData(argumentos[INDEX_DATA_REFERENCIA],
                    argumentos[INDEX_ANO_BISSEXTO]);

            return CalendarUtils.getDiaDaSemana(
                    argumentos[INDEX_DATA_INTERESSE],
                    argumentos[INDEX_ANO_BISSEXTO],
                    argumentos[INDEX_DATA_REFERENCIA],
                    argumentos[INDEX_DIA_DA_SEMANA]);

        } catch (IllegalArgumentException | DataInvalidaException ex) {
            return -1;
        }
    }
}
